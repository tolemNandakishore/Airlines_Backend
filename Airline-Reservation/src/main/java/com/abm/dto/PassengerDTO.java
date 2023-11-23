package com.abm.dto;

import com.abm.entity.Passengers.Gender;

public class PassengerDTO {
private String firstName;
private String lastName;
private String seatNumber;
private Gender gender;

public String getSeatNumber() {
	return seatNumber;
}
public void setSeatNumber(String seatNumber) {
	this.seatNumber = seatNumber;
}
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
//private Gender gender;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

}
