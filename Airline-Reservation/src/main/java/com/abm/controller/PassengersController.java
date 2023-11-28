package com.abm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.PassengerDTO;
import com.abm.dto.ReservationDetailsDTO;
import com.abm.dto.addPassengersStatus;
import com.abm.entity.Passengers;
import com.abm.entity.Reservation;
import com.abm.exception.PassengerServiceException;
import com.abm.service.PassengersService;

@RestController
@CrossOrigin
@RequestMapping("/passenger-controller")
public class PassengersController {
	@Autowired
	private PassengersService passengersService;
	private static final Logger log = LoggerFactory.getLogger(PassengersController.class);

	
	public addPassengersStatus addPassengers(@RequestBody Passengers passengers) {

		try {			
			Long id=passengersService.addPassengers(passengers);
			addPassengersStatus status=new addPassengersStatus();
			status.setStatus(true);
			status.setMessageIfAny("Passengers added Successfully..!");
			status.setPassengerId(id);		
			return status;
		}
		catch (PassengerServiceException e) {
			addPassengersStatus status=new addPassengersStatus();
			status.setStatus(true);
			status.setMessageIfAny("Passengers added already..!");
			return status;
		}
	}
	
	/*changes done by john*/ 
//	 @PostMapping("/add-passenger")
//	 public addPassengersStatus ProcessPassenger(@RequestBody ReservationDetailsDTO passengerDetailsDTO) {
//		 addPassengersStatus status=new addPassengersStatus();
//		 passengersService.addPassenger(passengerDetailsDTO.getPassengers());
//		 status.setStatus(true);
//			status.setMessageIfAny("Passengers added Successfully..!");	
//			return status;
//	 }
	
	@GetMapping("/passenger-controller/get-passenger")
	public List<Passengers> findByReservationId(@RequestParam Long reservationId) {
		return passengersService.getPassengersByReservationId(reservationId);
       
		
    }
	//http://localhost:7777/passenger-controller/passenger-controller/get-passenger?reservationId=33
}
