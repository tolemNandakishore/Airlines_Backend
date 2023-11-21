package com.abm.dto;

public class DeleteFlight {
	
	private boolean status;
	private String messageIfAny;
	private long flightId;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessageIfAny() {
		return messageIfAny;
	}
	public void setMessageIfAny(String messageIfAny) {
		this.messageIfAny = messageIfAny;
	}
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId2) {
		this.flightId = flightId2;
	}
	
	
}
