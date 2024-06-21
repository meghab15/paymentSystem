package services;

import exception.InsufficientBalanceException;
import exception.InvalidPaymentOperationException;
import exception.UserNotFoundException;
import models.Payment;
import models.Transaction;

public interface PaymentServiceI {

    public void pay(Payment payment) throws InvalidPaymentOperationException,
            InsufficientBalanceException, UserNotFoundException;
}
