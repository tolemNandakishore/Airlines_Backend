package com.abm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.dto.ReservationDetails;
import com.abm.entity.Flights;
import com.abm.entity.Passengers;
import com.abm.entity.Payments;
import com.abm.entity.Reservation;
import com.abm.exception.ReservationServiceException;
import com.abm.repository.FlightsRepository;
import com.abm.repository.ReservationRepository;
import com.abm.repository.UsersRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private FlightsRepository flightsRepository;
	@Autowired
	private UsersRepository userRepositiry;

	public Long addReservation(Reservation reservation) {

		Long count=reservationRepository.findIfReservationExists(reservation.getReservationId());
		if(count==0) {
			/*for(Passengers passengers:reservation.getReservationId()) {
				passengers.setReservation(reservation);*/

			List<Passengers> passengersList = reservation.getPassengers(); // Use the correct method to get passengers
			for (Passengers passengers : passengersList) {
				passengers.setReservation(reservation);
			}
			Reservation savedReservations=reservationRepository.save(reservation);
			return savedReservations.getReservationId();
		}
		else {
			throw new ReservationServiceException("Reservation already exists");
		}

	}
	
	public List<Reservation> findReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

	
	public Reservation bookTicket(ReservationDetails reservationDetails) {


		Reservation reservation = new Reservation();
		reservation.setFlightClass(reservationDetails.getClassFlight());//work on  this
		reservation.setReservationDate(reservationDetails.getReservationDate());
		reservation.setReservationDate(LocalDate.now());
		reservation.setFlight(flightsRepository.findByFlightId(reservationDetails.getFlightId()));
        reservation.setUser(userRepositiry.findByuserId(reservationDetails.getUserId()));
        
		List<Passengers> passengers = reservationDetails.getPassengers();
		for (Passengers passenger : passengers) {
			passenger.setReservation(reservation);
		}
		reservation.setPassengers(passengers);
		Double amount = reservationDetails.getAmount();
		
	    if (amount != null) {
	        reservation.setAmount(amount);
	    } else {
	    	reservation.setAmount(1000);
	        // Handle the case where amount is null, set a default value, log a message, etc.
	    }
	    Payments payment = new Payments();
	    payment.setAmount(amount);
	    payment.setCardName(reservationDetails.getCardName());
	    payment.setCardNumber(reservationDetails.getCardNumber());
	    payment.setCvv(reservationDetails.getCvv());
	   // payment.setPaymentDate(LocalDate.now());
	    payment.setReservation(reservation);
	    reservation.setPayment(payment);

		return reservationRepository.save(reservation);
	}

	public String cancleReservation(Long reservationId) {
		return reservationRepository.findByReservationId(reservationId);

	}
	
	

}
