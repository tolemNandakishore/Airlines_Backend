package com.abm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.abm.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tbl_Reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Reservation_Id")
	
	private Long reservationId;

	@ManyToOne//No need for reservation
	@JoinColumn(name = "User_Id")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "Flight_Id")
	private Flights flight;

	@Column(name = "Reservation_Date")
	private LocalDate reservationDate;

//	@Column(name = "Seat_Number")
//	private String seatNumber;
	
	private double amount;
    
	
	/*
	 * @Column(name = "Status") private String status;
	 */

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "Passenger_Id")
	 */
	
	@OneToMany(mappedBy = "reservation",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Passengers> passengers;

	
	@JsonIgnore
	@OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
	private Payments payment;

	@Column(name = "flight_class")
	private String flightClass;

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}


	public Users getUser() { return user; }




	public void setUser(Users user) { this.user = user; }


	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights long1) {
		this.flight = long1;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

//	public String getSeatNumber() {
//		return seatNumber;
//	}
//
//	public void setSeatNumber(String seatNumber) {
//		this.seatNumber = seatNumber;
//	}

	/*
	 * public String getStatus() { return status; }
	 */

	/*
	 * public void setStatus(String status) { this.status = status; }
	 */

	public List<Passengers> getPassengers() {
		return passengers;
	}




	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}


}
