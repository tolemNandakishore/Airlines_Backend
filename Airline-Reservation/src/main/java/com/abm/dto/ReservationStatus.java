package com.abm.dto;

import java.util.List;

import com.abm.entity.Passengers;

public class ReservationStatus {
	
	private boolean status;
	private String messageIfAny;
	private Long passengerId;
	private List<Passengers> passengers;
	
	private int userId;
	
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Passengers> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passengers> list) {
		this.passengers = list;
	}
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
	public Long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}
	
		

}
