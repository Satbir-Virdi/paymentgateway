package com.multicode.unrealpay.paymentgateway.control;

import com.multicode.unrealpay.paymentgateway.dto.*;
import com.multicode.unrealpay.paymentgateway.services.*;
import io.swagger.v3.oas.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.*;
import java.util.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentRequestController {

    @Autowired
    PaymentRegistrationService paymentRegistrationService;

    //Note we are always returning an object in this class because the return type could vary
    //for example if authorization fails

    @Operation(summary = "Request a new payment")
    @PostMapping
    public Object newPaymentRequest(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentRegistrationService.newPayment(paymentRequestDTO);
    }

    @Operation(summary = "Retrieve all payments")
    @GetMapping
    public Object getAllPayments() {
        return paymentRegistrationService.getAllPayments();
    }

    @Operation(summary = "Retrieve payment with specified ID")
    @GetMapping("/{transactionId}")
    public Object getPaymentStatus(@PathVariable("transactionId") UUID transactionId) {
        return paymentRegistrationService.getPaymentStatus(transactionId);
    }

    @Operation(summary = "Refund payment with specified ID")
    @PutMapping("/{transactionId}")
    public Object newRefundRequest(@PathVariable("transactionId") UUID transactionId) {
        return paymentRegistrationService.refundPayment(transactionId);
    }
}
