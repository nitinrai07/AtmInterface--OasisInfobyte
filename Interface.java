package Npackage;
import java.util.Scanner;

class ATM {
    String userId;
    String pin;
    private double balance;

    public ATM(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public void displayMenu() {
        System.out.println("Welcome, " + userId + "!");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void transfer(double amount, String recipient) {
        System.out.println("Transfer successful. Current balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
public class Interface {
    public static void main(String[] args) {
        ATM atm =new ATM("amit123", "4321", 1000.0);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter user ID:");
        String userId = sc.nextLine();
        System.out.println("Enter PIN:");
        String pin = sc.nextLine();

        if (!userId.equals(atm.userId) || !pin.equals(atm.pin)) {
            System.out.println("Invalid credentials. Exiting...");
            
        }

        int choice;
        do {
            atm.displayMenu();
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.showTransactionHistory();
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Enter amount to transfer:");
                    double transferAmount = sc.nextDouble();
                    System.out.println("Enter recipient's account:");
                    String recipient = sc.next();
                    atm.transfer(transferAmount, recipient);
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        sc.close();
    }
}




