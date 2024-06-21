package exception;

public class InvalidPaymentOperationException extends Exception{

    public InvalidPaymentOperationException() {
        super("Payment Mode is invalid for the transaction");
    }
}
