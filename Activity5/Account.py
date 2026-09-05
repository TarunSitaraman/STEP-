from AccountException import AccountException
from InvalidAmountException import InvalidAmountException
from InsufficientBalanceException import InsufficientBalanceException
from MinimumBalanceViolationException import MinimumBalanceViolationException
from InactiveAccountException import InactiveAccountException
from InvalidPinException import InvalidPinException

class Account:
    MIN_BALANCE_SAVINGS = 500.0
    MIN_BALANCE_CURRENT = 1000.0
    MIN_AGE = 18
    MIN_PIN = 1000
    MAX_PIN = 9999

    def __init__(self, accountNumber, name, age, initialBalance, accountType):
        if age < self.MIN_AGE:
            raise ValueError(f"Customer must be at least 18 years old. Provided: {age}")
        if accountType != "Savings" and accountType != "Current":
            raise ValueError(f"Account type must be 'Savings' or 'Current'. Provided: {accountType}")
        minBalance = self.MIN_BALANCE_SAVINGS if accountType == "Savings" else self.MIN_BALANCE_CURRENT
        if initialBalance < minBalance:
            raise ValueError(f"{accountType} account requires minimum balance of \u20b9{minBalance}. Provided: \u20b9{initialBalance:.1f}")
        self.__accountNumber = accountNumber
        self.__name = name
        self.__age = age
        self.__balance = initialBalance
        self.__accountType = accountType
        self.__status = "Active"
        self.__pin = None

    def deposit(self, amount):
        self.validateActive()
        if amount <= 0:
            raise InvalidAmountException(f"Deposit amount must be positive. Provided: \u20b9{amount:.1f}")
        self.__balance += amount

    def withdraw(self, amount, pin):
        self.validateActive()
        if self.__pin is None:
            raise InvalidPinException("PIN not set for this account")
        if not self.verifyPin(pin):
            raise InvalidPinException("Incorrect PIN")
        if amount <= 0:
            raise InvalidAmountException(f"Deposit amount must be positive. Provided: \u20b9{amount:.1f}")
        if amount > self.__balance:
            raise InsufficientBalanceException(f"Insufficient balance. Available: \u20b9{self.__balance:.1f}, Requested: \u20b9{amount:.1f}")
        minBalance = self.getMinimumBalance()
        if self.__balance - amount < minBalance:
            afterWithdrawal = self.__balance - amount
            raise MinimumBalanceViolationException(f"Cannot withdraw. Minimum balance of \u20b9{minBalance:.1f} required. Available after withdrawal: \u20b9{afterWithdrawal:.1f}")
        self.__balance -= amount

    def closeAccount(self):
        if self.__status == "Inactive":
            raise RuntimeError("Account is already closed")
        self.__status = "Inactive"

    def reopenAccount(self):
        if self.__status == "Active":
            raise RuntimeError("Account is already active")
        self.__status = "Active"

    def setPin(self, pin):
        if pin < self.MIN_PIN or pin > self.MAX_PIN:
            raise ValueError("PIN must be a 4-digit number")
        self.__pin = pin

    def verifyPin(self, pin):
        if self.__pin is None:
            return False
        return self.__pin == pin

    def hasPin(self):
        return self.__pin is not None

    def getMinimumBalance(self):
        if self.__accountType == "Savings":
            return self.MIN_BALANCE_SAVINGS
        return self.MIN_BALANCE_CURRENT

    def validateActive(self):
        if self.__status != "Active":
            raise InactiveAccountException("Account is inactive. Please reopen the account or contact support.")

    def getAccountNumber(self):
        return self.__accountNumber

    def getName(self):
        return self.__name

    def getAge(self):
        return self.__age

    def getBalance(self):
        return self.__balance

    def getAccountType(self):
        return self.__accountType

    def getStatus(self):
        return self.__status

    def setName(self, name):
        self.__name = name

    def setAge(self, age):
        self.__age = age
