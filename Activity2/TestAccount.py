import sys, os
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
sys.stdout.reconfigure(encoding='utf-8')
from Account import Account

print("=" * 50)
print("GLOBAL DIGITAL BANK - ACCOUNT TEST")
print("=" * 50)

print("\n>>> 1. Creating Account")
acc1 = Account(1001, "John Doe", 25, 1000.0, "Savings")
print("Account created!")
print(f"Account #{acc1.getAccountNumber()} | {acc1.getName()} ({acc1.getAge()} yrs) | {acc1.getAccountType()} | \u20b9{acc1.getBalance():.1f} | {acc1.getStatus()}")

print("\n>>> 2. Deposit Money")
if acc1.deposit(500.0):
    print("Depositing \u20b9500.0: SUCCESS")
else:
    print("Depositing \u20b9500.0: FAILED (Invalid amount)")
print(f"New balance: \u20b9{acc1.getBalance():.1f}")

if acc1.deposit(-100.0):
    print("Depositing \u20b9-100.0: SUCCESS")
else:
    print("Depositing \u20b9-100.0: FAILED (Invalid amount)")

print("\n>>> 3. Withdraw Money")
if acc1.withdraw(200.0):
    print("Withdrawing \u20b9200.0: SUCCESS")
else:
    print("Withdrawing \u20b9200.0: FAILED (Insufficient balance)")
print(f"New balance: \u20b9{acc1.getBalance():.1f}")

if acc1.withdraw(2000.0):
    print("Withdrawing \u20b92000.0: SUCCESS")
else:
    print("Withdrawing \u20b92000.0: FAILED (Insufficient balance)")
print(f"Current balance: \u20b9{acc1.getBalance():.1f}")

print("\n>>> 4. Creating Another Account")
acc2 = Account(1002, "Jane Smith", 30, 2000.0, "Current")
print(f"Account #{acc2.getAccountNumber()} | {acc2.getName()} ({acc2.getAge()} yrs) | {acc2.getAccountType()} | \u20b9{acc2.getBalance():.1f} | {acc2.getStatus()}")

print("\n>>> 5. All Accounts")
print(f"Account #{acc1.getAccountNumber()} | {acc1.getName()} ({acc1.getAge()} yrs) | {acc1.getAccountType()} | \u20b9{acc1.getBalance():.1f} | {acc1.getStatus()}")
print(f"Account #{acc2.getAccountNumber()} | {acc2.getName()} ({acc2.getAge()} yrs) | {acc2.getAccountType()} | \u20b9{acc2.getBalance():.1f} | {acc2.getStatus()}")

print("\n" + "=" * 50)
print("TEST COMPLETED!")
print("=" * 50)
