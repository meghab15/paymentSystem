package services;

import dao.PaymentDao;
import exception.InsufficientBalanceException;
import exception.InvalidPaymentOperationException;
import exception.UserNotFoundException;
import models.Payment;
import models.Paytm;

public class PaytmPaymentService implements PaymentServiceI {

    UserManagementService userService;
    PaymentDao paymentDao;

    public PaytmPaymentService(UserManagementService userService, PaymentDao paymentDao) {
        this.userService = userService;
        this.paymentDao = paymentDao;
    }

    @Override
    public void pay(Payment payment) throws InvalidPaymentOperationException,
            InsufficientBalanceException, UserNotFoundException {

        Paytm paytm = null;

        if (payment instanceof Paytm) {
            paytm = (Paytm) payment;
        } else throw new InvalidPaymentOperationException();

        if (!userService.withDrawMoney(paytm.getFromUserId(), payment.getAmount())) {
            System.out.println("Failed to withdraw Money");
            return;
        }

        if (!userService.depositMoney(paytm.getToUserId(), payment.getAmount())) {
            System.out.println("Failed in depositing Money");
            return;
        }
        paymentDao.storePaytmInfo(paytm);
    }


}
