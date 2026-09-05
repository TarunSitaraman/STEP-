import sys, os
sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "Activity7"))
sys.stdout.reconfigure(encoding='utf-8')
from SavingsAccount import SavingsAccount
from CurrentAccount import CurrentAccount

print("=" * 60)
print(" ACCOUNT SUBCLASSES TEST (SAVINGS & CURRENT)")
print("=" * 60)

# Test 1: Creating Accounts
print("\n>>> Test 1: Creating Accounts")
sav = SavingsAccount(1001, "John Doe", 25, 1000.0)
cur = CurrentAccount(1002, "Jane Smith", 30, 2000.0)
print(f"Savings Account: Account #{sav.getAccountNumber()} | {sav.getName()} ({sav.getAge()} yrs) | {sav.getAccountType()} | \u20b9{sav.getBalance():.1f} | {sav.getStatus()} | PIN: {'Yes' if sav.hasPin() else 'No'}")
print(f"Current Account: Account #{cur.getAccountNumber()} | {cur.getName()} ({cur.getAge()} yrs) | {cur.getAccountType()} | \u20b9{cur.getBalance():.1f} | {cur.getStatus()} | PIN: {'Yes' if cur.hasPin() else 'No'}")

# Test 2: Account Type and Minimum Balance
print("\n>>> Test 2: Account Type and Minimum Balance")
print(f"Savings Account - Type: {sav.getAccountType()}, Minimum Balance: \u20b9{sav.getMinimumBalance():.1f}")
print(f"Current Account - Type: {cur.getAccountType()}, Minimum Balance: \u20b9{cur.getMinimumBalance():.1f}")

# Test 3: Savings Account - Interest Calculation
print("\n>>> Test 3: Savings Account - Interest Calculation")
print(f"Savings Account: Account #{sav.getAccountNumber()} | {sav.getName()} ({sav.getAge()} yrs) | {sav.getAccountType()} | \u20b9{sav.getBalance():.1f} | {sav.getStatus()}")
print(f"Interest Rate: {sav.getInterestRate()}% per annum")
i1 = sav.calculateInterest(1)
i2 = sav.calculateInterest(2)
i5 = sav.calculateInterest(5)
print(f"Interest for 1 year: \u20b9{i1:.1f}")
print(f"Interest for 2 years: \u20b9{i2:.1f}")
print(f"Interest for 5 years: \u20b9{i5:.1f}")
print(f"After 2 years with interest: Balance would be \u20b9{sav.getBalance() + i2:.1f}")

# Test 4: Current Account - Overdraft Feature
print("\n>>> Test 4: Current Account - Overdraft Feature")
print(f"Current Account: Account #{cur.getAccountNumber()} | {cur.getName()} ({cur.getAge()} yrs) | {cur.getAccountType()} | \u20b9{cur.getBalance():.1f} | {cur.getStatus()}")
print(f"Overdraft Limit: \u20b9{cur.getOverdraftLimit():.1f}")
print(f"Available Overdraft: \u20b9{cur.getAvailableOverdraft():.1f}")
print(f"Overdraft Used: \u20b9{cur.getOverdraftUsed():.1f}")
print(f"Is Using Overdraft: {str(cur.isUsingOverdraft()).lower()}")

print("Withdrawing \u20b91500.0 (goes below minimum balance of \u20b91000)")
print(f"Balance before: \u20b9{cur.getBalance():.1f}")
cur.setPin(1234)
cur.withdraw(1500.0, 1234)
print("Withdrawing: \u20b91500.0 - SUCCESS")
print(f"Balance after: \u20b9{cur.getBalance():.1f}")
print(f"Overdraft Used: \u20b9{cur.getOverdraftUsed():.1f}")
print(f"Available Overdraft: \u20b9{cur.getAvailableOverdraft():.1f}")
print(f"Is Using Overdraft: {str(cur.isUsingOverdraft()).lower()}")

print("Attempting to withdraw \u20b94000.0 (would exceed overdraft)")
avail = cur.getBalance() + cur.getAvailableOverdraft()
print(f"Available funds: \u20b9{cur.getBalance():.1f} (balance) + \u20b9{cur.getAvailableOverdraft():.1f} (overdraft) = \u20b9{avail:.1f}")
try:
    cur.withdraw(4000.0, 1234)
except Exception as e:
    print(f"EXCEPTION: {e}")

print("Repaying overdraft of \u20b9500.0")
repayBalance = cur.getBalance()
print(f"Balance before repayment: \u20b9{repayBalance:.1f}")
print(f"Overdraft Used before: \u20b9{cur.getOverdraftUsed():.1f}")
cur.repayOverdraft(500.0)
print("Repaying \u20b9500.0 - SUCCESS")
print(f"Balance after repayment: \u20b9{cur.getBalance():.1f}")
print(f"Overdraft Used after: \u20b9{cur.getOverdraftUsed():.1f}")
print(f"Is Using Overdraft: {str(cur.isUsingOverdraft()).lower()}")

# Test 5: Polymorphism - Treating Accounts Uniformly
print("\n>>> Test 5: Polymorphism - Treating Accounts Uniformly")
print("Processing accounts polymorphically:")
accounts = []
try:
    accounts.append(SavingsAccount(1001, "John Doe", 25, 1000.0))
    accounts.append(CurrentAccount(1002, "Jane Smith", 30, 1000.0))
    accounts.append(SavingsAccount(1003, "Bob Wilson", 35, 500.0))
    accounts.append(CurrentAccount(1004, "Alice Brown", 28, 1500.0))
except Exception as e:
    print(f"EXCEPTION: {e}")

for acc in accounts:
    print(f"Account #{acc.getAccountNumber()} | {acc.getName()} ({acc.getAge()} yrs) | {acc.getAccountType()} | \u20b9{acc.getBalance():.1f} | {acc.getStatus()} | Type: {acc.getAccountType()}, Min Balance: \u20b9{acc.getMinimumBalance():.1f}")
totalBalance = sum(acc.getBalance() for acc in accounts)
print(f"Total accounts: {len(accounts)}")
print(f"Total balance across all accounts: \u20b9{totalBalance:.1f}")

# Test 6: Validation - Invalid Creation Attempts
print("\n>>> Test 6: Validation - Invalid Creation Attempts")
print("Attempting to create SavingsAccount with \u20b9300 (below minimum)")
try:
    SavingsAccount(1005, "Test", 25, 300.0)
except ValueError as e:
    print(f"EXCEPTION: {e}")
print("Attempting to create CurrentAccount with \u20b9500 (below minimum)")
try:
    CurrentAccount(1006, "Test", 25, 500.0)
except ValueError as e:
    print(f"EXCEPTION: {e}")
print("Attempting to create SavingsAccount with age 16")
try:
    SavingsAccount(1007, "Test", 16, 500.0)
except ValueError as e:
    print(f"EXCEPTION: {e}")

# Test 7: Savings Account - PIN and Operations
print("\n>>> Test 7: Savings Account - PIN and Operations")
sav2 = SavingsAccount(1005, "Charlie Green", 40, 2000.0)
print(f"Savings Account: Account #{sav2.getAccountNumber()} | {sav2.getName()} ({sav2.getAge()} yrs) | {sav2.getAccountType()} | \u20b9{sav2.getBalance():.1f} | {sav2.getStatus()}")
sav2.setPin(1234)
print("Setting PIN 1234: SUCCESS")
sav2.deposit(500.0)
print("Depositing \u20b9500.0: SUCCESS")
print(f"Balance after deposit: \u20b9{sav2.getBalance():.1f}")
sav2.withdraw(300.0, 1234)
print("Withdrawing \u20b9300.0 with correct PIN: SUCCESS")
print(f"Balance after withdrawal: \u20b9{sav2.getBalance():.1f}")
try:
    sav2.withdraw(2000.0, 1234)
except Exception as e:
    print("Attempting to withdraw \u20b92000.0 (would violate minimum balance)")
    print(f"EXCEPTION: {e}")

# Test 8: Current Account - Active Status Operations
print("\n>>> Test 8: Current Account - Active Status Operations")
cur2 = CurrentAccount(1006, "Diana Prince", 35, 3000.0)
print(f"Current Account: Account #{cur2.getAccountNumber()} | {cur2.getName()} ({cur2.getAge()} yrs) | {cur2.getAccountType()} | \u20b9{cur2.getBalance():.1f} | {cur2.getStatus()}")
cur2.closeAccount()
print("Closing account: SUCCESS")
print("Attempting to deposit \u20b9100.0 on closed account")
try:
    cur2.deposit(100.0)
except Exception as e:
    print(f"EXCEPTION: {e}")
cur2.reopenAccount()
print("Reopening account: SUCCESS")
cur2.deposit(100.0)
print("Depositing \u20b9100.0 after reopen: SUCCESS")
print(f"Balance after deposit: \u20b9{cur2.getBalance():.1f}")

# Test 9: All Accounts Summary
print("\n>>> Test 9: All Accounts Summary")
summaryAccounts = []
try:
    s1 = SavingsAccount(1001, "John Doe", 25, 1000.0)
    c1 = CurrentAccount(1002, "Jane Smith", 30, 1000.0)
    s2 = SavingsAccount(1003, "Bob Wilson", 35, 500.0)
    c2 = CurrentAccount(1004, "Alice Brown", 28, 1500.0)
    s3 = SavingsAccount(1005, "Charlie Green", 40, 2000.0)
    s3.setPin(1234)
    s3.deposit(500.0)
    s3.withdraw(300.0, 1234)
    c3 = CurrentAccount(1006, "Diana Prince", 35, 3000.0)
    c3.closeAccount()
    c3.reopenAccount()
    c3.deposit(100.0)
    summaryAccounts.extend([s1, c1, s2, c2, s3, c3])
except Exception as e:
    print(f"EXCEPTION: {e}")

for acc in summaryAccounts:
    print(f"Account #{acc.getAccountNumber()} | {acc.getName()} ({acc.getAge()} yrs) | {acc.getAccountType()} | \u20b9{acc.getBalance():.1f} | {acc.getStatus()} | PIN: {'Yes' if acc.hasPin() else 'No'}")

print("=" * 60)
print(" TEST COMPLETED!")
print("=" * 60)
