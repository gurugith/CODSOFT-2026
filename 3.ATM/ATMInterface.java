import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM Machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    // Display ATM Menu
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n====== ATM MACHINE ======");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    // Withdraw option
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    // Deposit option
    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Check balance option
    private void checkBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        // Initial balance
        BankAccount userAccount = new BankAccount(5000);
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
