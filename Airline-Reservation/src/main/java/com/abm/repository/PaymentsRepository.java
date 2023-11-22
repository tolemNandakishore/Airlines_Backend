package com.abm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abm.dto.PaymentRequestDto;
import com.abm.entity.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {
	
	Long save(PaymentRequestDto paymentRequestDto);

}
