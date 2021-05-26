package com.multicode.unrealpay.paymentgateway.domain;

import javax.persistence.*;

@Entity
public class RequestingSystem {

    @Id
    @GeneratedValue
    private Integer id;
    private String requesterCode;
    private Boolean active;

    public RequestingSystem() {}

    public RequestingSystem(Integer id, String requesterCode, Boolean active) {
        this.id = id;
        this.requesterCode = requesterCode;
        this.active = active;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRequesterCode(String requesterCode) {
        this.requesterCode = requesterCode;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public String getRequesterCode() {
        return requesterCode;
    }

    public Boolean getActive() {
        return active;
    }

    public String toString() {
        return this.requesterCode;
    }
}
