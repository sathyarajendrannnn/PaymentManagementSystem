package payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {
    private List<Account> accounts;
    private List<Transaction> transactions;

    public PaymentProcessor() {
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public Account createAccount(String accountHolderName) {
        Account newAccount = new Account(accountHolderName);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account findAccountById(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    public void processPayment(String accountId, double amount, String type) {
        Account account = findAccountById(accountId);
        if (account != null) {
            if (type.equalsIgnoreCase("credit")) {
                account.credit(amount);
            } else if (type.equalsIgnoreCase("debit")) {
                account.debit(amount);
            } else {
                System.out.println("Invalid transaction type.");
                return;
            }
            Transaction transaction = new Transaction(accountId, amount, type);
            transactions.add(transaction);
            System.out.println("Transaction successful: " + type + " of $" + amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void printTransactionHistory(String accountId) {
        System.out.println("Transaction history for account ID " + accountId + ":");
        for (Transaction transaction : transactions) {
            if (transaction.getAccountId().equals(accountId)) {
                System.out.println(transaction.getType() + " of $" + transaction.getAmount() + " on " + transaction.getTimestamp());
            }
        }
    }
}
