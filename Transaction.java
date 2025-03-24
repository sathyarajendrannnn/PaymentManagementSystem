package payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private String accountId;
    private double amount;
    private LocalDateTime timestamp;
    private String type;

    public Transaction(String accountId, double amount, String type) {
        this.transactionId = UUID.randomUUID().toString();
        this.accountId = accountId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }
}
