package com.multicode.unrealpay.paymentgateway.data;

import com.multicode.unrealpay.paymentgateway.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RequestingSystemRepository extends JpaRepository<RequestingSystem,Integer> {
    public RequestingSystem findByRequesterCode(String requesterCode);
}
