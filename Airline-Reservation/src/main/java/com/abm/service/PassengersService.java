package com.abm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.dto.PassengerDTO;
import com.abm.entity.Passengers;
import com.abm.entity.Reservation;
import com.abm.exception.PassengerServiceException;
import com.abm.repository.PassengersRepository;

@Service
public class PassengersService {
	@Autowired
	private PassengersRepository passengersRepository;

	public Long addPassengers(Passengers passengers) {
		Long count=passengersRepository.findIfPassengerExists(passengers.getPassengerId());
		if(count==0) {
			passengersRepository.save(passengers);
			return  passengers.getPassengerId();
		}
		else {
			throw new PassengerServiceException("Passenger already exists");
		}		
	}

	/*public Long  addPassengers(Passengers passengers) {
		passengersRepository.save(passengers);
		return "Passenger added successfully..!!";

	}*/
	
	/*changes by john*/
	public void addPassenger(List<PassengerDTO> passengerDTOlist) {
		 List<Passengers> passengersList = new ArrayList<>();
	for( PassengerDTO passengerDTO :passengerDTOlist) {	 
		Passengers passenger = new Passengers();
		passenger.setFirstName(passengerDTO.getFirstName());
		passenger.setLastName(passengerDTO.getLastName());
		
		passengersList.add(passenger);
	 }
	  passengersRepository.saveAll(passengersList);
	}

}
