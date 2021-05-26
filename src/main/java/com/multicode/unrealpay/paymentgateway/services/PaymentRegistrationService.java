package com.multicode.unrealpay.paymentgateway.services;

import com.multicode.unrealpay.paymentgateway.data.*;
import com.multicode.unrealpay.paymentgateway.domain.*;
import com.multicode.unrealpay.paymentgateway.dto.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.util.*;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.stream.*;

@Service
public class PaymentRegistrationService {

    @Autowired
    RequestingSystemRepository requestingSystemRepository;

    @Autowired
    PaymentRequestRepository paymentRequestRepository;

    @Autowired
    ExtractRequestingSystemService extractRequestingSystemService;

    @Autowired
    FraudEvaluationService fraudEvaluationService;

    ModelMapper modelMapper = new ModelMapper();

    public PaymentRegistrationOrErrorResponseDTO newPayment(PaymentRequestDTO dto) {
        RequestingSystem requestingSystem = extractRequestingSystemService.getRequestingSystem();
        PaymentRequest paymentRequest = modelMapper.map(dto, PaymentRequest.class);

        paymentRequest.setRequestingSystem(requestingSystem);

        try {
            String last4Digits = dto.getCardNumber().substring(dto.getCardNumber().length() - 4);
            paymentRequest.setLast4DigitsOfCardNumber(last4Digits);
        }
        catch (Exception e) {
            return new PaymentRegistrationOrErrorResponseDTO(902, "Card number is too short", null);
        }

        paymentRequest.setTransactionId(UUID.randomUUID());
        paymentRequest.setDate(new Date());

        paymentRequestRepository.save(paymentRequest);

        PaymentRegistrationOrErrorResponseDTO response = new PaymentRegistrationOrErrorResponseDTO();
        response.setResponseCode(100);
        response.setDescription("Payment request received");
        response.setTransactionId(paymentRequest.getTransactionId());
        return response;
    }

    public List<Object> getAllPayments() {
        RequestingSystem requestingSystem = extractRequestingSystemService.getRequestingSystem();

        List<PaymentRequest> payments = paymentRequestRepository.findAllByRequestingSystem(requestingSystem);
        List<Object> paymentSummaryList = payments.stream().map( payment ->
                modelMapper.map( payment, PaymentObjectSummaryDTO.class)).collect(Collectors.toList());
        return paymentSummaryList;
    }

    public Object getPaymentStatus(UUID transactionId) {
        RequestingSystem requestingSystem = extractRequestingSystemService.getRequestingSystem();

        PaymentRequest pr = paymentRequestRepository.findByTransactionId(transactionId);

        if(pr==null) {
            PaymentRegistrationOrErrorResponseDTO response = new PaymentRegistrationOrErrorResponseDTO();
            response.setResponseCode(902);
            response.setDescription("Transaction not found");
            Object returnResponse = response;
            return returnResponse;
        }

        if(!pr.getRequestingSystem().equals(requestingSystem)) {
            return new PaymentRegistrationOrErrorResponseDTO(903, "Transaction is not from your Requesting System", null);
        }

        if (pr.getPaymentResult() == null) {
            int score = fraudEvaluationService.getFraudScore();
            if (score > 90) {
                //FRAUD
                FraudResult fraudResult = new FraudResult();
                fraudResult.setFraudScore(score);
                fraudResult.setDescription(fraudEvaluationService.fraudDescription(score));
                pr.setFraudResult(fraudResult);

                PaymentResult paymentResult = new PaymentResult();
                paymentResult.setPaymentStatus(PaymentStatus.FAILED);
                paymentResult.setFailureReason(PaymentFailureReason.SUSPECTED_FRAUD);
                paymentResult.setDate(new Date());
                pr.setPaymentResult(paymentResult);
            }
            else if (score < 80) {
                //OK
                PaymentResult paymentResult = new PaymentResult();
                paymentResult.setPaymentStatus(PaymentStatus.SUCCESS);
                paymentResult.setDate(new Date());
                pr.setPaymentResult(paymentResult);
            }
            else {
                PaymentResult paymentResult = new PaymentResult();
                paymentResult.setPaymentStatus(PaymentStatus.FAILED);
                paymentResult.setFailureReason(PaymentFailureReason.REJECTED_BY_BANK);
                paymentResult.setDate(new Date());
                pr.setPaymentResult(paymentResult);

            }
            paymentRequestRepository.save(pr);

        }

        PaymentObjectDetailDTO response = modelMapper.map(pr, PaymentObjectDetailDTO.class);
        return (response);
    }

    public Object refundPayment(UUID transactionId) {
        RequestingSystem requestingSystem = extractRequestingSystemService.getRequestingSystem();

        PaymentRequest pr = paymentRequestRepository.findByTransactionId(transactionId);

        if(pr==null) {
            PaymentRegistrationOrErrorResponseDTO response = new PaymentRegistrationOrErrorResponseDTO();
            response.setResponseCode(902);
            response.setDescription("Transaction not found");
            Object returnResponse = response;
            return returnResponse;
        }

        if(!pr.getRequestingSystem().equals(requestingSystem)) {
            return new PaymentRegistrationOrErrorResponseDTO(903, "Transaction is not from your Requesting System", transactionId);
        }

        PaymentResult result = pr.getPaymentResult();

        if (result == null) {
            return new PaymentRegistrationOrErrorResponseDTO(921, "Transaction has not yet been processed - try again later", transactionId);
        }

        if (result.getPaymentStatus() == PaymentStatus.REFUNDED) {
            return new PaymentRegistrationOrErrorResponseDTO(924, "Transaction has already been refunded", transactionId);
        }

        if (result.getPaymentStatus() == PaymentStatus.FAILED) {
            return new PaymentRegistrationOrErrorResponseDTO(927, "Transaction did not succeed, so cannot be refunded", transactionId);
        }

        result.setPaymentStatus(PaymentStatus.REFUNDED);
        result.setDate(new Date());

        paymentRequestRepository.save(pr);

        return new PaymentRegistrationOrErrorResponseDTO(177, "Payment refunded", transactionId);
    }
}
