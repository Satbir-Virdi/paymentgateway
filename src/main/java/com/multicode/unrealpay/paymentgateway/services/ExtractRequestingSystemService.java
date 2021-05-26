package com.multicode.unrealpay.paymentgateway.services;

import com.multicode.unrealpay.paymentgateway.data.*;
import com.multicode.unrealpay.paymentgateway.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.context.request.*;

import javax.servlet.http.*;

@Service
public class ExtractRequestingSystemService {

    @Autowired
    RequestingSystemRepository requestingSystemRepository;

    public RequestingSystem getRequestingSystem() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestingSystem = request.getHeader("requesting-system");
        if (requestingSystem == null) return null;
        return requestingSystemRepository.findByRequesterCode(requestingSystem);
    }


}
