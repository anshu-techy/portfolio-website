
import java.util.Scanner;

class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrew: ₹" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void showDetails() {
        System.out.println("\nAccount Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    account = new BankAccount(name, accNo);
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ₹");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found. Please create one first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account found. Please create one first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.showDetails();
                    } else {
                        System.out.println("No account found. Please create one first.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Management System.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
