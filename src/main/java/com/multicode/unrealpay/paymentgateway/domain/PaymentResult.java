package com.multicode.unrealpay.paymentgateway.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class PaymentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private PaymentStatus paymentStatus;
    private PaymentFailureReason failureReason;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
