// Create a Java program that models a simple banking system using OOP. Define a BankAccount class with private fields for account number, account holder name, and balance, along with methods to deposit, withdraw, and print account details. Then create a subclass SavingsAccount that adds an interest rate and overrides the withdraw() method to prevent withdrawing more than the available balance. In your Main class, create objects of both classes, perform deposits and withdrawals, apply interest to the savings account, and display the final account details.

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void printDetails() {
        System.out.println(accountNumber + " " + accountHolderName + " " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) setBalance(getBalance() - amount);
    }

    public void applyInterest() {
        double newBalance = getBalance() + (getBalance() * interestRate);
        setBalance(newBalance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("A001", "Rahul", 5000);
        SavingsAccount account2 = new SavingsAccount("S001", "Sneha", 8000, 0.05);

        account1.deposit(10000);
        account1.withdraw(1000);

        account2.deposit(3000);
        account2.withdraw(5000);
        account2.applyInterest();

        account1.printDetails();
        account2.printDetails();
    }
}
