import java.util.Scanner;
import java.util.Random;

// BankingOperations Interface
interface BankingOperations {
    void createAccount(String accountHolder, double initialDeposit);
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// Account Abstract Class
abstract class Account implements BankingOperations {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    // Constructor
    public Account(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
    }

    // Abstract method to generate unique account number
    public abstract String generateAccountNumber();

    @Override
    public void createAccount(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

// BankAccount Class
class BankAccount extends Account {

    // Constructor that uses the constructor of the parent class
    public BankAccount(String accountHolder, double initialDeposit) {
        super(accountHolder, initialDeposit);
    }

    // Implementing the abstract method to generate a random 5-digit account number
    @Override
    public String generateAccountNumber() {
        Random rand = new Random();
        int accountNumber = rand.nextInt(90000) + 10000;  // generates a 5-digit number
        return String.valueOf(accountNumber);
    }
}

// Main Class
public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = null;

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder's name: ");
                    String name = scanner.next();
                    System.out.print("Enter initial deposit amount: ");
                    double initialDeposit = scanner.nextDouble();

                    bankAccount = new BankAccount(name, initialDeposit);
                    System.out.println("Account created successfully!");
                    System.out.println("Account Number: " + bankAccount.accountNumber);
                    break;

                case 2:
                    if (bankAccount == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;

                case 3:
                    if (bankAccount == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;

                case 4:
                    if (bankAccount == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    bankAccount.checkBalance();
                    break;

                case 5:
                    System.out.println("Exiting the bank system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
