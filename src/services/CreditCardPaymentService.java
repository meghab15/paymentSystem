package services;

import exception.InsufficientBalanceException;
import exception.InvalidPaymentOperationException;
import exception.UserNotFoundException;
import models.Payment;

public class CreditCardPaymentService implements PaymentServiceI{

    UserManagementService userService;

    public CreditCardPaymentService(UserManagementService userService) {
        this.userService = userService;
    }

    @Override
    public void pay(Payment payment) throws InvalidPaymentOperationException,
            InsufficientBalanceException, UserNotFoundException {

    }
}
