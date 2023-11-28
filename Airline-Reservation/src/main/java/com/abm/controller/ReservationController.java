package com.abm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.BookingStatus;
import com.abm.dto.ReservationDetails;
import com.abm.entity.Reservation;
import com.abm.exception.ReservationServiceException;
import com.abm.service.ReservationService;

@RestController
@CrossOrigin
@RequestMapping("/reservation_controller")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	
	
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

	
	
	@PostMapping("/flight/reservation")
	public BookingStatus booking(@RequestBody ReservationDetails reservationDetails ) {
		try {
		Reservation reservation = reservationService.bookTicket(reservationDetails);
		BookingStatus status=new BookingStatus();
		status.setStatus(true);
		status.setMessageIfAny("Booking Successfully..!");
		status.setReservationId(reservation.getReservationId());
		return status;
		}
		catch(Exception e) {
			BookingStatus status=new BookingStatus();
			status.setStatus(true);
			status.setMessageIfAny("reservation not completed.");
			return status;			
		}
		//http://localhost:7777/reservation_controller/flight/reservation
		
	}
	
	@PostMapping("/reservation/cancle")
	public String cancleReservation(@RequestParam Long reservationId) {
		 String result=reservationService.cancleReservation(reservationId);		
		 return result;
	}
	////http://localhost:7777/flight_controller/reservation/cancle?reservationId=20
	

	
	 @GetMapping("/reservation/myreservation")
    public List<Reservation> getReservationsByUserId(@RequestParam Long userId) {
        return reservationService.findReservationsByUserId(userId);
    }
  //http://localhost:7777//reservation_controller/reservation/myreservation?userId=123
}
