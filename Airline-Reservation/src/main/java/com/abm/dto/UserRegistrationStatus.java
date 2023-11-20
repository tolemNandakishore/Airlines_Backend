package com.abm.dto;

public class UserRegistrationStatus {
	
	private boolean status;
	private String messageIfAny;
	private int userId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
