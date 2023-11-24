package com.abm.service;

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
		Long count=flightsRepository.findIfFlightExists(flights.getFlightId());
		
		if(count==0) {
			Flights savedFlights=flightsRepository.save(flights);
			for(int i=1;i<=100;i++)
			{
				SeatAvailability seatAvailability=new SeatAvailability();
				seatAvailability.setSeatNumber(Integer.toString(i));
				seatAvailability.setAvailable(true);
				seatAvailability.setFlight(savedFlights);
				seatAvailabilityRepository.save(seatAvailability);
			}
			
			return  savedFlights.getFlightId();
		}
		else {
			 throw new FlightServiceException("Flight already exixts");
		}
				
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


