package services;

import exception.InsufficientBalanceException;
import exception.InvalidPaymentOperationException;
import exception.UserNotFoundException;
import models.Payment;
import models.PaymentMode;
import models.Transaction;

public class UpiPaymentService implements PaymentServiceI{

    UserManagementService userService;

    public UpiPaymentService(UserManagementService userService) {
        this.userService = userService;
    }

    @Override
    public void pay(Payment payment) throws InvalidPaymentOperationException,
            InsufficientBalanceException, UserNotFoundException {

    }
}