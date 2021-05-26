package com.multicode.unrealpay.paymentgateway.dto;

import java.util.*;

public class PaymentObjectSummaryDTO {

    private String requestingSystem;
    private String requesterReference;
    private UUID transactionId;
    private Double amount;
    private String currency;
    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRequestingSystem() {
        return requestingSystem;
    }

    public void setRequestingSystem(String requestingSystem) {
        this.requestingSystem = requestingSystem;
    }

    public String getRequesterReference() {
        return requesterReference;
    }

    public void setRequesterReference(String requesterReference) {
        this.requesterReference = requesterReference;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
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
}
