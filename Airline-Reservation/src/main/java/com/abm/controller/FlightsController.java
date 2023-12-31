package com.abm.controller;
import java.util.ArrayList;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
//github.com/tolemNandakishore/Airlines_Backend
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.DeleteFlight;
import com.abm.dto.FlightAddingStatus;
import com.abm.dto.FlightUpdateRequest;
import com.abm.dto.FlightsAddingRequest;
import com.abm.entity.Flights;
import com.abm.entity.SeatAvailability;
import com.abm.exception.FlightServiceException;
import com.abm.repository.FlightsRepository;
import com.abm.service.FlightsService;

@RestController
@RequestMapping("/flights-controller")
@CrossOrigin
public class FlightsController {

	@Autowired
	private FlightsService flightsService;
	@Autowired
	private FlightsRepository flightsRepository;
	// Start writing the Methods regarding to flights
	private static final Logger log = LoggerFactory.getLogger(FlightsController.class);

	/*
	 * { "departureTime": "2023-11-05T10:00:00", "arrivalTime":
	 * "2023-11-05T15:30:00", "from": "City A", "to": "City B" }
	 */
	// http://localhost:7777/flights-controller/adding-flights
	/*@PostMapping("/adding-flights")
	public String addFlights(@RequestBody FlightsAddingRequest request) {
		String response = flightsService.addFlights(request);

		return response;
	}*/

	@PostMapping("/adding-flights")
	public FlightAddingStatus addFlights(@RequestBody Flights flights) {
		try {
			Long id=flightsService.addFlights(flights);

			FlightAddingStatus status=new FlightAddingStatus();
			status.setStatus(true);
			status.setMessageIfAny("Flight added successfully");

			status.setFlightId(id);


			status.setFlightId(id);			
			
//github.com/tolemNandakishore/Airlines_Backend
			return status;
		}
		catch (FlightServiceException e) {
			FlightAddingStatus status=new FlightAddingStatus();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
		//http://localhost:7777/flights-controller/adding-flights
	}

	// http://localhost:7777/flights-controller/flight-search?from=mumbai&to=goa

	@GetMapping("/flight-search")
	public List<Flights> flightSearching(@RequestParam String from, @RequestParam String to) {
		List<Flights> allFlights= flightsService.flightSearching(from, to);
		//write the code to return only those flights which are operated by Air India

		/*List<Flights> airIndiaFlights= new ArrayList<>();

		for(Flights flight:allFlights) {
			if(flight.getFlightName().equals("Air India"))
				airIndiaFlights.add(flight);
		}*/
		
		/*for(Flights flight:allFlights) {
			if(isOperatedByAirIndia(flight)) {
				airIndiaFlights.add(flight);

			}
			
		}*/
		
		

		return allFlights;
	}
	
	/*private boolean  isOperatedByAirIndia(Flights flight) {
		String flightname=flight.getFlightName();
		return "Air India".equals(flightname);
	}*/

	@PutMapping("/update-flight/{flightId}")
	public String  flightUpdate( @RequestBody Flights	request, @PathVariable Long  flightId) {

		String result=flightsService.flightUpdate(request);

		return result; 
	}
	//	http://localhost:7777/flights-controller/update-flight/{flightId}1001



	@DeleteMapping("/delete-flight/{flightId}")
	public String deleteByFlightId(@PathVariable Long flightId) {
		// log.info("controller before"+orderId);
		String response = flightsService.deleteByFlightId(flightId);
		return response;
	}
	// http://localhost:7777/flights-controller/delete-flight/{flightId}

	@GetMapping("/fetch-details/{flightId}")
	public Flights fetchDetailsByFlightId(@PathVariable Long flightId) {
		Flights flights= flightsService.fetchDetailsByFlightId(flightId);
		return flights;

	}
	// http://localhost:7777/flights-controller/fetch-details/1001
	@PostMapping("/flightstatus")
	public DeleteFlight stauts(@RequestParam long flightId) {
		flightsService.flightcancel(flightId);
		DeleteFlight delete=new DeleteFlight();
		delete.setFlightId(flightId);
		delete.setStatus(true);
		delete.setMessageIfAny("cancel flight sucessfully");
		return delete;
	}
	// http://localhost:7777/flights-controller/flightstatus?flightId=2
	
	
	 @GetMapping("/getAllFlights")
	 public List<Flights>getAll() {
        return flightsService.getAll();
	    }
	 // http://localhost:7777/flights-controller/getAllFlights
	 
	 
	 @PutMapping("/update-flights")
		public Flights editFlights(@RequestBody Flights flights) {
		flightsService.editFlights(flights);
		Flights f=new Flights();
		f.setDepartureTime(LocalDateTime.now());
		f.setArrivalTime(LocalDateTime.now());
		f.setFrom("from");
		f.setTo("to");
		f.setPrice(111);
		f.setStatus("true");
		return f;
		}
	 // http://localhost:7777/flights-controller/update-flights
//>>>>>>> branch 'master' of https://github.com/tolemNandakishore/Airlines_Backend
	 @GetMapping("/all-flights")
	 public List<String> getAllFlightNames() {
		List<String>flightNames= flightsService.getAllFlightNames();
		 return flightNames;
		 
	 }
	 // http://localhost:7777/flights-controller/all-flights
}
