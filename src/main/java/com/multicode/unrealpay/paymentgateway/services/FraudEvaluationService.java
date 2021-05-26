package com.multicode.unrealpay.paymentgateway.services;

import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FraudEvaluationService {

    Random random = new Random();

    public int getFraudScore() {
        return random.nextInt(100);
    }

    public boolean paymentSucceeded(int fraudScore) {
        return fraudScore < 80;
    }

    public String fraudDescription(int fraudScore) {
        if (fraudScore < 80) return "OK";
        if (fraudScore < 85) return "Card has been blocked";
        if (fraudScore < 90) return "CV2 mismatch";
        return "Transaction was declined by bank.";
    }

}

