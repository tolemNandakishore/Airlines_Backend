package com.abm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_Passengers")
public class Passengers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Passenger_Id")
	private Long passengerId;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "Seat_Number")
	private String seatNumber;
	
	private Gender gender;
     
	public static enum Gender{ MALE,FEMALE,OTHER; }
	 

	// @OneToMany(mappedBy = "passengers", cascade = CascadeType.ALL)
	@ManyToOne // Change from @OneToMany to @ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Reservation_Id") 
	private Reservation reservation;

	public Long getPassengerId() {
		return passengerId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

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

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


}
