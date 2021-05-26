package com.multicode.unrealpay.paymentgateway.domain;

public enum PaymentFailureReason {
    INVALID_CARD_NUMBER, INVALID_CV2, CARD_EXPIRED, SUSPECTED_FRAUD,
    INSUFFICIENT_FUNDS, REJECTED_BY_BANK

}
