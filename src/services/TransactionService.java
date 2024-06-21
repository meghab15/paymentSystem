package services;

import dao.TransactionDao;
import exception.InvalidPaymentOperationException;
import models.Transaction;
import models.TransactionStatus;

public class TransactionService {

    TransactionDao transactionDao;
    PaymentFactory paymentFactory;

    public TransactionService(TransactionDao transactionDao, PaymentFactory paymentFactory ) {
        this.transactionDao = transactionDao;
        this.paymentFactory = paymentFactory;
    }

    public void createTransaction(Transaction transaction){
        transactionDao.createTransaction(transaction);
    }

    public void markTransactionSuccess(Transaction transaction) {
        transactionDao.updateTransactionStatus(transaction.getTransactionId(),
                TransactionStatus.SUCCESS, null);
    }

    public void markTransactionFailed(Transaction transaction) {
        transactionDao.updateTransactionStatus(transaction.getTransactionId(),
                TransactionStatus.FAILED,
                transaction.getFailureReason());
    }
}
