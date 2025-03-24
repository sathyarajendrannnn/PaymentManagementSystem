package payment;

import java.util.Scanner;

public class PaymentManagementSystem {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Payment Management System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Process Payment");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    Account newAccount = paymentProcessor.createAccount(accountHolderName);
                    System.out.println("Account created successfully. Account ID: " + newAccount.getAccountId());
                    break;
                case 2:
                    System.out.print("Enter account ID: ");
                    String accountId = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter transaction type (credit/debit): ");
                    String type = scanner.nextLine();
                    paymentProcessor.processPayment(accountId, amount, type);
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    accountId = scanner.nextLine();
                    Account account = paymentProcessor.findAccountById(accountId);
                    if (account != null) {
                        System.out.println("Account balance: $" + account.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account ID: ");
                    accountId = scanner.nextLine();
                    paymentProcessor.printTransactionHistory(accountId);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
