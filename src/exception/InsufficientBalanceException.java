package exception;

public class InsufficientBalanceException extends  Exception{

    public InsufficientBalanceException() {
        super("Payment Failed due to insufficient balance");
    }
}
