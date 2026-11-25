import java.util.Scanner;

public class BankingManagement {

    static int accountNumber;
    static String accountHolder;
    static double balance;
    static String history = "";

    static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history += "Deposited: Rs. " + amount + "\n";
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    static void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history += "Withdrawn: Rs. " + amount + "\n";
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    static void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    static void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs. " + balance);
    }

    static void showHistory() {
        System.out.println("\n--- Transaction History ---");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println(history);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANKING MANAGEMENT SYSTEM =====");

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        accountHolder = sc.nextLine();

        if (accountHolder.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            sc.close();
            return;
        }

        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid initial balance!");
            sc.close();
            return;
        }

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    withdraw(sc.nextDouble());
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    displayDetails();
                    break;

                case 5:
                    showHistory();
                    break;

                case 6:
                    System.out.println("Thank you for using our bank!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
