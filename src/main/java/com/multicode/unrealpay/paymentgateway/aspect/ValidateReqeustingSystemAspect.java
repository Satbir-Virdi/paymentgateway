package com.multicode.unrealpay.paymentgateway.aspect;

import com.multicode.unrealpay.paymentgateway.data.*;
import com.multicode.unrealpay.paymentgateway.domain.*;
import com.multicode.unrealpay.paymentgateway.dto.*;
import com.multicode.unrealpay.paymentgateway.services.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.context.request.*;

import javax.servlet.http.*;

@Aspect
@Component
public class ValidateReqeustingSystemAspect {

    @Autowired
    ExtractRequestingSystemService extractRequestingSystemService;

    @Pointcut("execution(* com.multicode.unrealpay.paymentgateway.control.PaymentRequestController.* (..)))")
    public void checkRequestingSystemIsInHeader() {}

    @Around("checkRequestingSystemIsInHeader()")
    public Object validateRequestingSystem(ProceedingJoinPoint  joinPoint) throws Throwable {
        RequestingSystem requestingSystem = extractRequestingSystemService.getRequestingSystem();
        if (requestingSystem != null) {
            return joinPoint.proceed();
        }
        else {
            PaymentRegistrationOrErrorResponseDTO response = new PaymentRegistrationOrErrorResponseDTO();
            response.setResponseCode(999);
            response.setDescription("Unauthorised - missing or invalid Requesting System specified in header");
            return response;
        }

    }
}
