package com.abm.dto;

import java.util.List;

public class ReservationDetailsDTO {
	
	List<PassengerDTO> passengers ;

	public List<PassengerDTO> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerDTO> passengers) {
		this.passengers = passengers;
	}
	
}
