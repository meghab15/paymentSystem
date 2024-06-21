package models;

import java.util.UUID;

public class Transaction {

    private final String transactionId;
    private User fromUser;
    private User toUser;
    private final TransactionType type;
    private Account bankAccount;
    private TransactionStatus status;
    private final Double amount;
    private TransactionFailureReason failureReason;

    public Transaction(User fromUser, User toUser, Double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
        this.type = TransactionType.USER_TO_USER;
        this.status = TransactionStatus.CREATED;
    }

    public Transaction(User fromUser, Account bankAccount, Double amount,  TransactionType type) {
        this.transactionId = UUID.randomUUID().toString();
        this.fromUser = fromUser;
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.type = type;
        this.status = TransactionStatus.CREATED;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public TransactionType getType() {
        return type;
    }

    public Account getBankAccount() {
        return bankAccount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public Double getAmount() {
        return amount;
    }

    public TransactionFailureReason getFailureReason() {
        return failureReason;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void markStatusFailed(TransactionFailureReason failureReason) {
        this.status= TransactionStatus.FAILED;
        this.failureReason = failureReason;
    }

    public  void markStatusSuccess() {
        this.status= TransactionStatus.SUCCESS;
        this.failureReason = null;
    }

}
