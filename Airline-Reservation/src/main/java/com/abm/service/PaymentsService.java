package com.abm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.dto.PaymentRequestDto;
import com.abm.entity.Payments;
import com.abm.repository.PaymentsRepository;
import com.abm.repository.ReservationRepository;

@Service
public class PaymentsService {

	@Autowired
	private PaymentsRepository paymentsRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	public Long payment(PaymentRequestDto paymentRequestDto) {

		Payments payments= new Payments();
		// payments.setPaymentId(paymentRequestDto.get);
		payments.setAmount(paymentRequestDto.getAmount());
		payments.setCardName(paymentRequestDto.getCardName());
		payments.setCardNumber(paymentRequestDto.getCardNumber());
		paymentRequestDto.setCvv(paymentRequestDto.getCvv());
		payments.setPaymentDate(paymentRequestDto.getPaymentData().now());
		//  payments.setReservation(reservationRepository.findById(paymentRequestDto.get));
		/*
		 * if (paymentRequestDto.getReservationId() != null) {
		 * payments.setReservation(reservationRepository.findById(paymentRequestDto.
		 * getReservationId()).orElse(null)); }
		 */
		//payments.setReservation(paymentRequestDto.getReservationId());
		return paymentsRepository.save(paymentRequestDto);

	}

}
