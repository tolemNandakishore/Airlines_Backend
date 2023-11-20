package com.abm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.BookingStatus;
import com.abm.dto.ReservationDetails;
import com.abm.exception.ReservationServiceException;
import com.abm.service.ReservationService;

@RestController
@CrossOrigin
@RequestMapping("/reservation_controller")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	
	
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

	/*@PostMapping("/reservation")
	public ReservationStatus addReservation(@RequestBody Reservation reservation) {
		try {
			Long id=reservationService.addReservation(reservation);
			ReservationStatus status=new ReservationStatus();
			status.setStatus(true);
			status.setMessageIfAny("reservation completed successfully..!!");
			status.setPassengers(reservation.getPassengers());
			status.setUserId(reservation.getUser().getUserId());
			status.setPassengerId(id);
			
			return status;
		}
		catch (ReservationServiceException e) {
			ReservationStatus status=new ReservationStatus();
			status.setStatus(true);
			status.setMessageIfAny("reservation Not completed .!!");
			return status;
		}
	}
	//http://localhost:7777/reservation_controller/reservation*/
	
	@PostMapping("/flight/reservation")
	public BookingStatus booking(@RequestBody ReservationDetails reservationDetails ) {
		try {
		Long id=reservationService.bookTicket(reservationDetails);
		BookingStatus status=new BookingStatus();
		status.setStatus(true);
		status.setMessageIfAny("Booking Successfully..!");
		status.setReservationId(id);
		return status;
		}
		catch(ReservationServiceException e) {
			BookingStatus status=new BookingStatus();
			status.setStatus(true);
			status.setMessageIfAny("reservation not completed.");
			return status;			
		}
		//http://localhost:7777/reservation_controller/reservation
		
	}
	
	@PostMapping("/reservation/cancle")
	public String cancleReservation(@RequestParam Long reservationId) {
		 String result=reservationService.cancleReservation(reservationId);		
		 return result;
	}
	////http://localhost:7777/flight_controller/reservation/cancle?reservationId=20

}
