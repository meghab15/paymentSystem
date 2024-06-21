package models;

import java.util.UUID;

public class Payment {

    private String id;
    private Transaction transaction;
    private Double amount;

    public Payment(Double amount, Transaction transaction) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.transaction = transaction;
    }

    public String getId() {
        return id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Double getAmount() {
        return amount;
    }

}
