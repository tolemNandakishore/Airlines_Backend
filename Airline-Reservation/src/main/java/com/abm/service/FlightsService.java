package com.abm.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.abm.entity.Flights;
import com.abm.entity.SeatAvailability;
import com.abm.exception.FlightServiceException;
import com.abm.repository.FlightsRepository;
import com.abm.repository.SeatAvailabilityRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

@Service
public class FlightsService {  

	@Autowired
	private FlightsRepository  flightsRepository;
	
	@Autowired
	private SeatAvailabilityRepository seatAvailabilityRepository;
	

	public List<Flights> flightSearching(String from, String to) {
		return flightsRepository. findByFromAndTo(from,to);
	}


	public String flightUpdate(Flights request) {
		flightsRepository.save(request);
		return "Flight updated successfully...!!";
	}

	public String deleteByFlightId(Long flightId) {
		flightsRepository.deleteById(flightId);
		return "Flight delete successfully...!!";
	}

	public Flights fetchDetailsByFlightId(Long flightId) {
		return flightsRepository.findByFlightId(flightId);
	}

	public Long addFlights(Flights flights) {
			Flights savedFlights=flightsRepository.save(flights);
			LocalDate startDate = LocalDate.now().plus(1,  ChronoUnit.DAYS);
			LocalDate endDate = startDate.plus(30, ChronoUnit.DAYS);
			long noOfDays = ChronoUnit.DAYS.between(startDate, endDate);
			
			LocalDate date = startDate;
			for(int i=0; i<noOfDays; i++) {
				for(int j=0; j<100; j++) {
					SeatAvailability seatAvailability = new SeatAvailability();
					seatAvailability.setSeatNumber(Integer.toString(j+1));
					seatAvailability.setAvailable(true);
					seatAvailability.setDate(endDate);
					seatAvailability.setDate(date);
					seatAvailability.setFlight(savedFlights);
					seatAvailabilityRepository.save(seatAvailability);
				}
				date = startDate.plus(1, ChronoUnit.DAYS);
			}

			
			return  savedFlights.getFlightId();
				
	}

	public long flightcancel(long flightId) {
		Flights flight=flightsRepository.findById(flightId).get();
		flight.setStatus("cancel");
		flightsRepository.save(flight);
		return flightId;	
	}


	public List<Flights> getAll() {
		List<Flights>flightList=flightsRepository.findAll();
		return flightList;
	}


	public Flights editFlights(Flights flights) {
		Flights flight=flightsRepository.save(flights);
		return flight;
	}

    
	public List<String> getAllFlightNames() {
		List<String> flights=flightsRepository.findByFlightNameIsNotNull();
		return  flights.stream().collect(Collectors.toList());
		
	}
		
}


