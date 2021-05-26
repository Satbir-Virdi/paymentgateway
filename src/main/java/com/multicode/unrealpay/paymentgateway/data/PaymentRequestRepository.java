package com.multicode.unrealpay.paymentgateway.data;

import com.multicode.unrealpay.paymentgateway.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface PaymentRequestRepository extends JpaRepository<PaymentRequest, Integer> {

    public List<PaymentRequest> findAllByRequestingSystem(RequestingSystem requestingSystem);

    public PaymentRequest findByTransactionId(UUID transactionId);
}
