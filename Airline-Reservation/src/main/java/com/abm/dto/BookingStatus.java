package com.abm.dto;

import com.abm.entity.Reservation;

public class BookingStatus extends Status {

	private long reservationId;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	
	
}
