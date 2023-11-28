package com.abm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abm.entity.Passengers;

@Repository
public interface PassengersRepository  extends JpaRepository<Passengers, Long>{
     
	@Query("select count(c) from Passengers c where c.passengerId = ?1")
	Long findIfPassengerExists(Long passengerId);

	@Query("SELECT p FROM Passengers p WHERE p.reservation.reservationId = :reservationId")
    List<Passengers> findByReservationId(@Param("reservationId") Long reservationId);
}
