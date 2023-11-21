package com.abm.dto;

import java.util.List;

import com.abm.entity.Passengers;

public class ReservationDetails {
	
	private Long flightId;
	
	private List<Passengers>passengers;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public List<Passengers> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

}
