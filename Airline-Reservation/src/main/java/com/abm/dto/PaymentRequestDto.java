package com.abm.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.abm.entity.Reservation;

public class PaymentRequestDto {
	private Long cardNumber;
	private String cvv;
	private String cardName;
	private Long amount;
	private LocalDateTime paymentData;
	private Reservation reservation;
	private Long reservationId;
	
	
	
	 public Long getReservationId() { return reservationId; } public void
	 setReservationId(Long reservationId) { this.reservationId = reservationId; }
	
	
	public Long getCardNumber() {
		return cardNumber;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public LocalDateTime getPaymentData() {
		return paymentData;
	}
	public void setPaymentData(LocalDateTime paymentData) {
		this.paymentData = paymentData;
	}




}
