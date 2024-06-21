import dao.PaymentDao;
import dao.TransactionDao;
import dao.UserDao;
import exception.InsufficientBalanceException;
import exception.InvalidPaymentOperationException;
import exception.UserNotFoundException;
import models.*;
import services.*;

public class Main {
    public static void main(String[] args) throws InvalidPaymentOperationException {

        System.out.println("Hello, Welcome to payment World!");

        UserDao userDao= new UserDao();

        String meghaPhoneNo = "7799814891";
        String ganeshPhoneNo = "9555562494";

        UserManagementService userManagementService = new UserManagementService(userDao);
//
//        userManagementService.registerUser(ganeshPhoneNo, "mysecretkey");
//
//        User user2= userManagementService.getUserByPhoneNoOrId(ganeshPhoneNo, null);
//
//        userManagementService.updateUser("Ganesh Kedia", "ganesh.kedia@gmail.com",
//                ganeshPhoneNo);
//
//        if(user2!=null) {
//            userManagementService.getUserByPhoneNoOrId(null, user2.getUserId());
//        }

        User user1 = userManagementService.getUserByPhoneNoOrId(meghaPhoneNo, null);
        User user2 = userManagementService.getUserByPhoneNoOrId(ganeshPhoneNo, null);

        PaymentDao paymentDao = new PaymentDao();
        PaymentFactory paymentFactory = fetchPaymentFactory(userManagementService, paymentDao);

        TransactionDao transactionDao = new TransactionDao();

        TransactionService transactionService = new TransactionService(transactionDao, paymentFactory);
        // User Enters Mobile no, transaction is created on this user;
        Transaction transaction = new Transaction(user1, user2, 900.00);
        transactionService.createTransaction(transaction);

        PaymentMode paymentMode = PaymentMode.Paytm;

        Payment payment = new Paytm(transaction, transaction.getAmount());
        PaymentServiceI paymentService = paymentFactory.getPaymentService(paymentMode);
        try {
            paymentService.pay(payment);
            transaction.markStatusSuccess();
            transactionService.markTransactionSuccess(transaction);
        }
        catch(InsufficientBalanceException e) {
            System.out.println("Transaction Failed due to insufficient Balance ");
            transaction.markStatusFailed(TransactionFailureReason.INSUFFICIENT_BALANCE);
            transactionService.markTransactionFailed(transaction);
        }
        catch(InvalidPaymentOperationException e) {
            System.out.println("Transaction Failed due to Unknown Error ");
            transaction.markStatusFailed(TransactionFailureReason.SOMETHING_WENT_WRONG);
            transactionService.markTransactionFailed(transaction);
        }
        catch(UserNotFoundException e) {
            System.out.println("User not found for the transaction! ");
            transaction.markStatusFailed(TransactionFailureReason.USER_NOT_FOUND);
            transactionService.markTransactionFailed(transaction);
        }
    }

    public static PaymentFactory fetchPaymentFactory(UserManagementService userManagementService,
                                                     PaymentDao paymentDao) {
        PaytmPaymentService paytmPaymentService = new PaytmPaymentService(userManagementService, paymentDao);
        CreditCardPaymentService ccPaymentService = new CreditCardPaymentService(userManagementService);
        NetBankingPaymentService netBankingPaymentService = new NetBankingPaymentService(userManagementService);
        UpiPaymentService upiPaymentService = new UpiPaymentService(userManagementService);

        return  new PaymentFactory(paytmPaymentService,
                ccPaymentService, netBankingPaymentService, upiPaymentService);
    }
}