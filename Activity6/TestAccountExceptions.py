import sys, os
sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "Activity5"))
sys.stdout.reconfigure(encoding='utf-8')
from Account import Account
from InvalidAmountException import InvalidAmountException
from InsufficientBalanceException import InsufficientBalanceException
from MinimumBalanceViolationException import MinimumBalanceViolationException
from InactiveAccountException import InactiveAccountException
from InvalidPinException import InvalidPinException

print("=" * 60)
print(" ACCOUNT TEST WITH EXCEPTIONS")
print("=" * 60)

# Test 1: Valid Account Creation
print("\n>>> Test 1: Valid Account Creation")
try:
    acc1 = Account(1001, "John Doe", 25, 1000.0, "Savings")
    print(f"SUCCESS: Account #{acc1.getAccountNumber()} | {acc1.getName()} ({acc1.getAge()} yrs) | {acc1.getAccountType()} | \u20b9{acc1.getBalance():.1f} | {acc1.getStatus()} | PIN: {'Yes' if acc1.hasPin() else 'No'}")
except Exception as e:
    print(f"EXCEPTION: {e}")

# Test 2: Invalid Age (under 18)
print("\n>>> Test 2: Invalid Age (under 18)")
try:
    acc2 = Account(1002, "Young Kid", 16, 500.0, "Savings")
    print(f"SUCCESS: Account created")
except ValueError as e:
    print(f"EXCEPTION: {e}")

# Test 3: Invalid Account Type
print("\n>>> Test 3: Invalid Account Type")
try:
    acc3 = Account(1003, "Test User", 25, 500.0, "Invalid")
    print(f"SUCCESS: Account created")
except ValueError as e:
    print(f"EXCEPTION: {e}")

# Test 4: Minimum Balance on Creation
print("\n>>> Test 4: Minimum Balance on Creation")
print("Creating Savings account with \u20b9300")
try:
    acc4 = Account(1004, "Bob Wilson", 25, 300.0, "Savings")
    print(f"SUCCESS: Account created")
except ValueError as e:
    print(f"EXCEPTION: {e}")

# Test 5: Valid Deposit and Withdrawal
print("\n>>> Test 5: Valid Deposit and Withdrawal")
try:
    acc5 = Account(1005, "Alice Brown", 30, 1000.0, "Current")
    print(f"Account: Account #{acc5.getAccountNumber()} | {acc5.getName()} ({acc5.getAge()} yrs) | {acc5.getAccountType()} | \u20b9{acc5.getBalance():.1f} | {acc5.getStatus()} | PIN: {'Yes' if acc5.hasPin() else 'No'}")
    acc5.setPin(1234)
    print("Setting PIN 1234: SUCCESS")
    acc5.deposit(500.0)
    print("Depositing \u20b9500.0: SUCCESS")
    print(f"Balance after deposit: \u20b9{acc5.getBalance():.1f}")
    acc5.withdraw(200.0, 1234)
    print("Withdrawing \u20b9200.0: SUCCESS")
    print(f"Balance after withdrawal: \u20b9{acc5.getBalance():.1f}")
    print(f"Account #{acc5.getAccountNumber()} | {acc5.getName()} ({acc5.getAge()} yrs) | {acc5.getAccountType()} | \u20b9{acc5.getBalance():.1f} | {acc5.getStatus()} | PIN: Yes")
except Exception as e:
    print(f"EXCEPTION: {e}")

# Test 6: Invalid Deposit (Negative Amount)
print("\n>>> Test 6: Invalid Deposit (Negative Amount)")
print("Attempting to deposit \u20b9-100.0")
try:
    acc6 = Account(1006, "Charlie Green", 35, 500.0, "Savings")
    acc6.setPin(1234)
    acc6.deposit(-100.0)
    print("SUCCESS")
except InvalidAmountException as e:
    print(f"EXCEPTION: {e}")

# Test 7: Insufficient Balance
print("\n>>> Test 7: Insufficient Balance")
try:
    acc7 = Account(1006, "Charlie Green", 35, 500.0, "Savings")
    acc7.setPin(1234)
    print(f"Account: Account #{acc7.getAccountNumber()} | {acc7.getName()} ({acc7.getAge()} yrs) | {acc7.getAccountType()} | \u20b9{acc7.getBalance():.1f} | {acc7.getStatus()} | PIN: Yes")
    print("Attempting to withdraw \u20b91000.0")
    acc7.withdraw(1000.0, 1234)
    print("SUCCESS")
except InsufficientBalanceException as e:
    print(f"EXCEPTION: {e}")

# Test 8: Minimum Balance Violation
print("\n>>> Test 8: Minimum Balance Violation")
try:
    acc8 = Account(1007, "Diana Prince", 28, 1000.0, "Savings")
    acc8.setPin(1234)
    print(f"Account: Account #{acc8.getAccountNumber()} | {acc8.getName()} ({acc8.getAge()} yrs) | {acc8.getAccountType()} | \u20b9{acc8.getBalance():.1f} | {acc8.getStatus()} | PIN: Yes")
    print("Attempting to withdraw \u20b9600.0")
    acc8.withdraw(600.0, 1234)
    print("SUCCESS")
except MinimumBalanceViolationException as e:
    print(f"EXCEPTION: {e}")

# Test 9: Inactive Account Operations
print("\n>>> Test 9: Inactive Account Operations")
try:
    acc9 = Account(1008, "Eve Wilson", 32, 2000.0, "Current")
    print(f"Account: Account #{acc9.getAccountNumber()} | {acc9.getName()} ({acc9.getAge()} yrs) | {acc9.getAccountType()} | \u20b9{acc9.getBalance():.1f} | {acc9.getStatus()} | PIN: {'Yes' if acc9.hasPin() else 'No'}")
    acc9.closeAccount()
    print("Closing account: SUCCESS")
    print("Attempting to deposit \u20b9100.0 on closed account")
    try:
        acc9.deposit(100.0)
    except InactiveAccountException as e:
        print(f"EXCEPTION: {e}")
    acc9.reopenAccount()
    print("Reopening account: SUCCESS")
    acc9.deposit(100.0)
    print("Depositing \u20b9100.0 after reopen: SUCCESS")
    print(f"Balance after deposit: \u20b9{acc9.getBalance():.1f}")
except Exception as e:
    print(f"EXCEPTION: {e}")

# Test 10: PIN Verification
print("\n>>> Test 10: PIN Verification")
try:
    acc10 = Account(1009, "Frank Miller", 40, 1500.0, "Savings")
    print(f"Account: Account #{acc10.getAccountNumber()} | {acc10.getName()} ({acc10.getAge()} yrs) | {acc10.getAccountType()} | \u20b9{acc10.getBalance():.1f} | {acc10.getStatus()} | PIN: {'Yes' if acc10.hasPin() else 'No'}")
    acc10.setPin(1234)
    print("Setting PIN 1234: SUCCESS")
    acc10.withdraw(200.0, 1234)
    print("Withdrawing \u20b9200.0 with correct PIN: SUCCESS")
    print(f"Balance: \u20b9{acc10.getBalance():.1f}")
    print("Attempting to withdraw \u20b9100.0 with incorrect PIN (9999)")
    try:
        acc10.withdraw(100.0, 9999)
    except InvalidPinException as e:
        print(f"EXCEPTION: {e}")
    print("Attempting to withdraw \u20b9100.0 without PIN set")
    try:
        acc11 = Account(1010, "No Pin Guy", 30, 1000.0, "Savings")
        acc11.withdraw(100.0, 0)
    except InvalidPinException as e:
        print(f"EXCEPTION: {e}")
except Exception as e:
    print(f"EXCEPTION: {e}")

# Test 11: All Accounts Summary
print("\n>>> Test 11: All Accounts Summary")
accounts = []
try:
    accounts.append(Account(1001, "John Doe", 25, 1000.0, "Savings"))
except: pass
try:
    accounts.append(Account(1005, "Alice Brown", 30, 1000.0, "Current"))
    accounts[-1].setPin(1234)
    accounts[-1].deposit(500.0)
    accounts[-1].withdraw(200.0, 1234)
except: pass
try:
    acc_temp = Account(1006, "Charlie Green", 35, 500.0, "Savings")
    acc_temp.setPin(1234)
    accounts.append(acc_temp)
except: pass
try:
    acc_temp = Account(1007, "Diana Prince", 28, 1000.0, "Savings")
    acc_temp.setPin(1234)
    accounts.append(acc_temp)
except: pass
try:
    acc_temp = Account(1008, "Eve Wilson", 32, 2000.0, "Current")
    acc_temp.closeAccount()
    acc_temp.reopenAccount()
    accounts.append(acc_temp)
except: pass
try:
    acc_temp = Account(1009, "Frank Miller", 40, 1500.0, "Savings")
    acc_temp.setPin(1234)
    acc_temp.withdraw(200.0, 1234)
    accounts.append(acc_temp)
except: pass

for acc in accounts:
    print(f"Account #{acc.getAccountNumber()} | {acc.getName()} ({acc.getAge()} yrs) | {acc.getAccountType()} | \u20b9{acc.getBalance():.1f} | {acc.getStatus()} | PIN: {'Yes' if acc.hasPin() else 'No'}")

print("=" * 60)
print(" TEST COMPLETED!")
print("=" * 60)
