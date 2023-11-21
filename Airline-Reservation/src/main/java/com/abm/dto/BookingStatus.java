package com.abm.dto;

import com.abm.entity.Reservation;

public class BookingStatus extends Status {

	private Reservation ReservationId;
	

	public Reservation getReservationId() {
		return ReservationId;
	}

	public void setReservationId(Reservation id) {
		ReservationId = id;
	}
	
	
}
