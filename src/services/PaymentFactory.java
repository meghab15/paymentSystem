package services;

import models.PaymentMode;

public class PaymentFactory {
    PaytmPaymentService paytmPaymentService;

    CreditCardPaymentService ccPaymentService;

    NetBankingPaymentService netBankingPaymentService;

    UpiPaymentService upiPaymentService;

    public PaymentFactory(PaytmPaymentService paytmPaymentService,
                          CreditCardPaymentService ccPaymentService,
                          NetBankingPaymentService netBankingPaymentService,
                          UpiPaymentService upiPaymentService) {
        this.paytmPaymentService = paytmPaymentService;
        this.ccPaymentService = ccPaymentService;
        this.netBankingPaymentService = netBankingPaymentService;
        this.upiPaymentService = upiPaymentService;
    }

    public PaymentServiceI getPaymentService(PaymentMode mode) {
        return switch (mode) {
            case UPI -> upiPaymentService;
            case CC -> ccPaymentService;
            case NET_BANKING -> netBankingPaymentService;
            default -> paytmPaymentService; // for paytm mode
        };
    }
}
