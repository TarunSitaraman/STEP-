from abc import ABC, abstractmethod
from AccountException import AccountException
from InvalidAmountException import InvalidAmountException
from InsufficientBalanceException import InsufficientBalanceException
from MinimumBalanceViolationException import MinimumBalanceViolationException
from InactiveAccountException import InactiveAccountException
from InvalidPinException import InvalidPinException

class Account(ABC):
    MIN_AGE = 18
    MIN_PIN = 1000
    MAX_PIN = 9999

    def __init__(self, accountNumber, name, age, initialBalance):
        if age < self.MIN_AGE:
            raise ValueError(
                "Customer must be at least " + str(self.MIN_AGE) +
                " years old. Provided: " + str(age)
            )
        minBalance = self.getMinimumBalance()
        if initialBalance < minBalance:
            raise ValueError(
                self.getAccountType() + " account requires minimum balance of \u20b9" + str(minBalance) +
                ". Provided: \u20b9" + str(initialBalance)
            )
        self.accountNumber = accountNumber
        self.name = name
        self.age = age
        self.balance = initialBalance
        self.status = "Active"
        self.pin = None

    def deposit(self, amount):
        self.validateActive()
        if amount <= 0:
            raise InvalidAmountException(
                "Deposit amount must be positive. Provided: \u20b9" + str(amount)
            )
        self.balance += amount

    def withdraw(self, amount, pin):
        self.validateActive()
        self.validatePin(pin)
        self.validateAmount(amount)
        if amount > self.balance:
            raise InsufficientBalanceException(
                "Insufficient balance. Available: \u20b9" + str(self.balance) +
                ", Requested: \u20b9" + str(amount)
            )
        minBalance = self.getMinimumBalance()
        if self.balance - amount < minBalance:
            afterWithdrawal = self.balance - amount
            raise MinimumBalanceViolationException(
                "Cannot withdraw. Minimum balance of \u20b9" + str(minBalance) +
                " required. Available after withdrawal: \u20b9" + str(afterWithdrawal)
            )
        self.balance -= amount

    def closeAccount(self):
        if self.status == "Inactive":
            raise RuntimeError("Account is already closed")
        self.status = "Inactive"

    def reopenAccount(self):
        if self.status == "Active":
            raise RuntimeError("Account is already active")
        self.status = "Active"

    def setPin(self, pin):
        if pin < self.MIN_PIN or pin > self.MAX_PIN:
            raise ValueError("PIN must be a 4-digit number")
        self.pin = pin

    def verifyPin(self, pin):
        if self.pin is None:
            return False
        return self.pin == pin

    def hasPin(self):
        return self.pin is not None

    @abstractmethod
    def getMinimumBalance(self):
        pass

    @abstractmethod
    def getAccountType(self):
        pass

    def validateActive(self):
        if self.status != "Active":
            raise InactiveAccountException(
                "Account is inactive. Please reopen the account or contact support."
            )

    def validatePin(self, pin):
        if self.pin is None:
            raise InvalidPinException("PIN not set for this account")
        if not self.verifyPin(pin):
            raise InvalidPinException("Incorrect PIN")

    def validateAmount(self, amount):
        if amount <= 0:
            raise InvalidAmountException(
                "Deposit amount must be positive. Provided: \u20b9" + str(amount)
            )

    def getBalance(self):
        return self.balance

    def setBalance(self, balance):
        self.balance = balance

    def getAccountNumber(self):
        return self.accountNumber

    def getName(self):
        return self.name

    def getAge(self):
        return self.age

    def getStatus(self):
        return self.status

    def setName(self, name):
        self.name = name

    def setAge(self, age):
        self.age = age
