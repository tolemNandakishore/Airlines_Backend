package com.abm.dto;

public class RegistrationStatus {

	private boolean status;
	private String messageIfAny;
	private Long customerId;
	
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
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long id) {
		this.customerId = id;
	}
}
