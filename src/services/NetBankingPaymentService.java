package services;

import exception.InsufficientBalanceException;
import exception.InvalidPaymentOperationException;
import exception.UserNotFoundException;
import models.Payment;
import models.Transaction;

public class NetBankingPaymentService implements PaymentServiceI{

    UserManagementService userService;

    public NetBankingPaymentService(UserManagementService userService) {
        this.userService = userService;
    }

    @Override
    public void pay(Payment payment) throws InvalidPaymentOperationException,
            InsufficientBalanceException, UserNotFoundException {

    }
}