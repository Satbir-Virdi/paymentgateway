package com.multicode.unrealpay.paymentgateway.dto;

public class PaymentRequestDTO {

    private String requesterReference;

    private String cardNumber;

    private Integer cv2;
    private Integer expiryMonth;
    private Integer expiryYear;

    private Double amount;
    private String currency;

    public String getRequesterReference() {
        return requesterReference;
    }

    public void setRequesterReference(String requesterReference) {
        this.requesterReference = requesterReference;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCv2() {
        return cv2;
    }

    public void setCv2(Integer cv2) {
        this.cv2 = cv2;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
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
