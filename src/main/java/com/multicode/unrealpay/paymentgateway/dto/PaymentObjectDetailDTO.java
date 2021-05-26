package com.multicode.unrealpay.paymentgateway.dto;

import com.multicode.unrealpay.paymentgateway.domain.*;

import java.util.*;

public class PaymentObjectDetailDTO {
    private UUID transactionId;
    private RequestingSystem requestingSystem;
    private String requesterReference;
    private String last4DigitsOfCardNumber;
    private Double amount;
    private String currency;
    private Date date;
    private Integer fraudScore;
    private Boolean fraudulent;
    private String description;
    private PaymentStatus paymentStatus;
    private PaymentFailureReason failureReason;

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public RequestingSystem getRequestingSystem() {
        return requestingSystem;
    }

    public void setRequestingSystem(RequestingSystem requestingSystem) {
        this.requestingSystem = requestingSystem;
    }

    public String getRequesterReference() {
        return requesterReference;
    }

    public void setRequesterReference(String requesterReference) {
        this.requesterReference = requesterReference;
    }

    public String getLast4DigitsOfCardNumber() {
        return last4DigitsOfCardNumber;
    }

    public void setLast4DigitsOfCardNumber(String last4DigitsOfCardNumber) {
        this.last4DigitsOfCardNumber = last4DigitsOfCardNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getFraudScore() {
        return fraudScore;
    }

    public void setFraudScore(Integer fraudScore) {
        this.fraudScore = fraudScore;
    }

    public Boolean getFraudulent() {
        return fraudulent;
    }

    public void setFraudulent(Boolean fraudulent) {
        this.fraudulent = fraudulent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentFailureReason getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(PaymentFailureReason failureReason) {
        this.failureReason = failureReason;
    }
}
