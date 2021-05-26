package com.multicode.unrealpay.paymentgateway.domain;

import com.multicode.unrealpay.paymentgateway.dto.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.*;

@Entity
public class PaymentRequest {

    public PaymentRequest () {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID transactionId;

    @ManyToOne
    private RequestingSystem requestingSystem;

    private String requesterReference;

    private String last4DigitsOfCardNumber;

    private Integer cv2;
    private Integer expiryMonth;
    private Integer expiryYear;

    private Double amount;
    private String currency;

    @OneToOne(cascade=CascadeType.PERSIST)
    private FraudResult fraudResult;

    @OneToOne(cascade = CascadeType.PERSIST)
    private PaymentResult paymentResult;

    Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public FraudResult getFraudResult() {
        return fraudResult;
    }

    public void setFraudResult(FraudResult fraudResult) {
        this.fraudResult = fraudResult;
    }

    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(PaymentResult paymentResult) {
        this.paymentResult = paymentResult;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
