import sys, os
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
sys.stdout.reconfigure(encoding='utf-8')
from SavingsAccount import SavingsAccount
from CurrentAccount import CurrentAccount

print("=" * 60)
print(" ACCOUNT INHERITANCE TEST")
print("=" * 60)

print("\n>>> Test 1: Savings Account Creation")
try:
    sav = SavingsAccount(2001, "Alice Smith", 25, 500.0)
    print(f"SUCCESS: Account #{sav.getAccountNumber()} | {sav.getName()} | {sav.getAccountType()} | \u20b9{sav.getBalance():.1f} | Min Balance: \u20b9{sav.getMinimumBalance():.1f}")
    print(f"Interest Rate: {sav.getInterestRate()}%")
    interest = sav.calculateInterest(2)
    print(f"Interest after 2 years: \u20b9{interest:.1f}")
except Exception as e:
    print(f"EXCEPTION: {e}")

print("\n>>> Test 2: Current Account Creation")
try:
    cur = CurrentAccount(2002, "Bob Johnson", 30, 1000.0)
    print(f"SUCCESS: Account #{cur.getAccountNumber()} | {cur.getName()} | {cur.getAccountType()} | \u20b9{cur.getBalance():.1f} | Min Balance: \u20b9{cur.getMinimumBalance():.1f}")
    print(f"Overdraft Limit: \u20b9{cur.getOverdraftLimit():.1f}")
    print(f"Available Overdraft: \u20b9{cur.getAvailableOverdraft():.1f}")
    print(f"Using Overdraft: {cur.isUsingOverdraft()}")
except Exception as e:
    print(f"EXCEPTION: {e}")

print("\n>>> Test 3: Overdraft Withdrawal")
try:
    cur2 = CurrentAccount(2003, "Carol White", 35, 1000.0)
    cur2.setPin(1234)
    print(f"Initial Balance: \u20b9{cur2.getBalance():.1f}")
    cur2.withdraw(4000.0, 1234)
    print(f"Withdrew \u20b94000.0: SUCCESS")
    print(f"Balance after withdrawal: \u20b9{cur2.getBalance():.1f}")
    print(f"Overdraft Used: \u20b9{cur2.getOverdraftUsed():.1f}")
    print(f"Available Overdraft: \u20b9{cur2.getAvailableOverdraft():.1f}")
    print(f"Using Overdraft: {cur2.isUsingOverdraft()}")
except Exception as e:
    print(f"EXCEPTION: {e}")

print("\n>>> Test 4: Invalid Age (under 18)")
try:
    sav2 = SavingsAccount(2004, "Young Kid", 16, 500.0)
    print("SUCCESS")
except ValueError as e:
    print(f"EXCEPTION: {e}")

print("\n>>> Test 5: Invalid Minimum Balance")
try:
    sav3 = SavingsAccount(2005, "Test User", 25, 300.0)
    print("SUCCESS")
except ValueError as e:
    print(f"EXCEPTION: {e}")

print("\n>>> Test 6: PIN Operations")
try:
    sav4 = SavingsAccount(2006, "Diana Prince", 28, 1000.0)
    sav4.setPin(1234)
    sav4.deposit(500.0)
    print(f"Balance after deposit: \u20b9{sav4.getBalance():.1f}")
    sav4.withdraw(200.0, 1234)
    print(f"Withdrawal with correct PIN: SUCCESS")
    print(f"Balance: \u20b9{sav4.getBalance():.1f}")
    try:
        sav4.withdraw(100.0, 9999)
    except Exception as e:
        print(f"EXCEPTION: {e}")
except Exception as e:
    print(f"EXCEPTION: {e}")

print("\n>>> Test 7: Polymorphism - Treating All Accounts Uniformly")
accounts = []
try:
    accounts.append(SavingsAccount(3001, "Frank Miller", 40, 1500.0))
    accounts.append(CurrentAccount(3002, "Grace Lee", 33, 2000.0))
    accounts.append(SavingsAccount(3003, "Henry Ford", 45, 1000.0))
except Exception as e:
    print(f"EXCEPTION: {e}")

print("\nAll Accounts Summary:")
for acc in accounts:
    print(f"Account #{acc.getAccountNumber()} | {acc.getName()} | {acc.getAccountType()} | \u20b9{acc.getBalance():.1f} | Active | PIN: {'Yes' if acc.hasPin() else 'No'}")

print("\n>>> Test 8: Repay Overdraft")
try:
    cur3 = CurrentAccount(2007, "Ivy Chen", 29, 1000.0)
    cur3.setPin(1234)
    cur3.withdraw(3000.0, 1234)
    print(f"Overdraft Used: \u20b9{cur3.getOverdraftUsed():.1f}")
    cur3.repayOverdraft(1000.0)
    print(f"After repaying \u20b91000.0:")
    print(f"Overdraft Used: \u20b9{cur3.getOverdraftUsed():.1f}")
    print(f"Balance: \u20b9{cur3.getBalance():.1f}")
    print(f"Available Overdraft: \u20b9{cur3.getAvailableOverdraft():.1f}")
except Exception as e:
    print(f"EXCEPTION: {e}")

print("\n>>> Test 9: Savings Account Invalid Interest")
try:
    sav5 = SavingsAccount(2008, "Jack Ryan", 30, 1000.0)
    sav5.calculateInterest(-1)
except ValueError as e:
    print(f"EXCEPTION: {e}")

print("\n>>> Test 10: Current Account Exceed Overdraft")
try:
    cur4 = CurrentAccount(2009, "Karen Page", 27, 1000.0)
    cur4.setPin(1234)
    cur4.withdraw(7000.0, 1234)
    print("SUCCESS")
except Exception as e:
    print(f"EXCEPTION: {e}")

print("=" * 60)
print(" INHERITANCE TEST COMPLETED!")
print("=" * 60)
