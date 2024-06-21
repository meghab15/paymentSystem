package models;

public class Paytm extends Payment {

    private String fromUserId;
    private String toUserId;
    private PaymentMode mode;

    public Paytm(Transaction transaction, Double amount) {
        super(amount, transaction);
        this.mode = PaymentMode.Paytm;
        this.fromUserId = transaction.getFromUser().getUserId();
        this.toUserId = transaction.getToUser().getUserId();
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public PaymentMode getMode() {
        return mode;
    }


}
