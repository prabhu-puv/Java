import java.util.*;
 
// Define the BankingOperations interface
interface BankingOperations {
    void createAccount(String accountHolder, double initialDeposit);
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}
 
// Abstract Account class implementing BankingOperations
abstract class Account implements BankingOperations {
    public String accountNumber;
    public String accountHolder;
    public double balance;
 
    // Abstract method to generate account number
    public abstract String generateAccountNumber();
 
    // Constructor
    public Account(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
    }
 
    // Implementing common BankingOperations methods
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
 
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
 
    @Override
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
 
// BankAccount class extending Account
class BankAccount extends Account {
    private static final Random random = new Random();
 
    // Constructor
    public BankAccount(String accountHolder, double initialDeposit) {
        super(accountHolder, initialDeposit);
    }
 
    // Generate a random 5-digit account number
        @Override
        public String generateAccountNumber() {
            return String.format("%05d", random.nextInt(100000));
        }
 
    @Override
    public void createAccount(String accountHolder, double initialDeposit) {
        System.out.println("Account created successfully.");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Initial Deposit: " + balance);
    }
}
 
// Main class
public class Bank1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;
 
        while (true) {
            System.out.println("\nBanking Application Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
 
            switch (choice) {
                case 1:
                    if (account == null) {
                        System.out.print("Enter account holder name: ");
                        scanner.nextLine(); // Consume newline
                        String name = scanner.nextLine();
                        System.out.print("Enter initial deposit amount: ");
                        double initialDeposit = scanner.nextDouble();
                        account = new BankAccount(name, initialDeposit);
                        account.createAccount(name, initialDeposit);
                        
                    } else {
                        System.out.println("An account already exists.");
                    }
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account exists. Create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account exists. Create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.checkBalance();
                        account.generateAccountNumber();
                    } else {
                        System.out.println("No account exists. Create an account first.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
 