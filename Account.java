package payment;

import java.util.UUID;

public class Account {
    private String accountId;
    private String accountHolderName;
    private double balance;

    public Account(String accountHolderName) {
        this.accountId = UUID.randomUUID().toString();
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid credit amount.");
        }
    }

    public void debit(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid debit amount or insufficient funds.");
        }
    }
}
