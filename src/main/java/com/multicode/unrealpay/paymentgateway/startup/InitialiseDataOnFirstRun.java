package com.multicode.unrealpay.paymentgateway.startup;

import com.multicode.unrealpay.paymentgateway.data.*;
import com.multicode.unrealpay.paymentgateway.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.annotation.*;

@Component
public class InitialiseDataOnFirstRun {

    @Autowired
    RequestingSystemRepository requestingSystemRepository;

    @PostConstruct
    public void initData() {
        if (requestingSystemRepository.findAll().size() == 0) {
            RequestingSystem rs1 = new RequestingSystem(null,"BRL",true);
            RequestingSystem rs2 = new RequestingSystem(null,"RJK",false);
            RequestingSystem rs3 = new RequestingSystem(null,"MTY",true);
            requestingSystemRepository.save(rs1);
            requestingSystemRepository.save(rs2);
            requestingSystemRepository.save(rs3);
        };
    }
}

