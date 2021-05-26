package com.multicode.unrealpay.paymentgateway.domain;

import javax.persistence.*;

@Entity
public class FraudResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer fraudScore;
    private Boolean fraudulent;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
