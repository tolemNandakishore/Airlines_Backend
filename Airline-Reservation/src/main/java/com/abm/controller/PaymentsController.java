package com.abm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.PaymentRequestDto;
import com.abm.dto.PaymentStatus;
import com.abm.exception.PaymentServiceException;
import com.abm.service.PaymentsService;

@RestController
@CrossOrigin
@RequestMapping("/payments_controller")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    private static final Logger log = LoggerFactory.getLogger(PaymentsController.class);
//
//    @PostMapping("/add/payment")
//    public PaymentStatus addPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
//        try {
//            Long id = paymentsService.payment(paymentRequestDto);
//            PaymentStatus status = new PaymentStatus();
//            status.setStatus(true);
//            status.setMessageIfAny("Payment successfully completed..!!");
//            status.setPaymentId(id);
//            return status;
//        } catch (PaymentServiceException e) {
//            PaymentStatus status = new PaymentStatus();
//            status.setStatus(false);
//            status.setMessageIfAny("Payment not successfully completed..!!");
//            return status;
//        }
        // http://localhost:7777/payments_controller/add/payment
  //  }
}

