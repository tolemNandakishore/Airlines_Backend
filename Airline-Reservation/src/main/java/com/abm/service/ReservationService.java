package com.abm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.dto.ReservationDetails;
import com.abm.entity.Flights;
import com.abm.entity.Passengers;
import com.abm.entity.Reservation;
import com.abm.exception.ReservationServiceException;
import com.abm.repository.FlightsRepository;
import com.abm.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private FlightsRepository flightsRepository;

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

	public Long bookTicket(ReservationDetails reservationDetails) {
		Flights  flights=	flightsRepository.findById(reservationDetails.getFlightId()).get();
		Reservation reservation=new  Reservation();
		reservation.setFlight(flights);
		reservation.setReservationDate(LocalDate.now());
		/*reservation.setSeatNumber(null);//ask to sir...!!		
		 * reservation.setFlightClass(null); reservation.setAmount(5000);
		 */
		for(Passengers passengers:reservationDetails.getPassengers())
			passengers.setReservation(reservation);
		reservation.setPassengers(reservationDetails.getPassengers());
		Reservation r= reservationRepository.save(reservation);
		return r.getReservationId();
	}

	
	public String cancleReservation(Long reservationId) {
		return reservationRepository.findByReservationId(reservationId);
				
	}

}
