package com.multicode.unrealpay.paymentgateway.dto;

import java.util.*;

public class PaymentRegistrationOrErrorResponseDTO {
    private int responseCode;
    private String description;
    private UUID transactionId;

    public PaymentRegistrationOrErrorResponseDTO(int responseCode, String description, UUID transactionId) {
        this.responseCode = responseCode;
        this.description = description;
        this.transactionId = transactionId;
    }

    public PaymentRegistrationOrErrorResponseDTO() {}

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }
}
