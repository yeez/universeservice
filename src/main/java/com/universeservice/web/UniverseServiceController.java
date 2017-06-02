package com.universeservice.web;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universeservice.domain.entity.SearchParameters;
import com.universeservice.domain.entity.UniverseEvent;
import com.universeservice.service.UniverseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@Description("Provides API for Universe Service Component")
@RequestMapping(value = "/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UniverseServiceController {

	private final UniverseService universeService;

	@Autowired
	public UniverseServiceController(final UniverseService universeService) {
		this.universeService = universeService;
	}

	//Ping Test for the Microservice
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<List<UniverseEvent>> ping(){

		return new ResponseEntity<List<UniverseEvent>>(universeService.returnPingTestValue(), HttpStatus.OK);
	}

	// Load sample data into in-memory db 
	@RequestMapping(value = "/events/import", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UniverseEvent>> receiveEvents(@Valid @RequestBody final List<UniverseEvent> universeEvents){

		return new ResponseEntity<List<UniverseEvent>>(universeService.loadEventsIntoMemory(universeEvents), HttpStatus.OK);
	}

	// Return event by event_name
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public ResponseEntity<List<UniverseEvent>> searchByName(@RequestParam(value = "eventName", required = true) String eventName){

		return new ResponseEntity<List<UniverseEvent>>(universeService.getEventByName(eventName), HttpStatus.OK);
	}

	// Return nearest 100 planets, Planets with distance closest to 0 are considered closest
	@RequestMapping(value = "/events/nearest100", method = RequestMethod.GET)
	public ResponseEntity<List<UniverseEvent>> returnNearestEvents(){
		
		return new ResponseEntity<List<UniverseEvent>>(universeService.getNearestEvents(), HttpStatus.OK);
	}

	// Finds Planets according to the search criteria specified in the SearchParameters json object
	@RequestMapping(value = "/events/findPlanets", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UniverseEvent>> findPlanets(@Valid @RequestBody final SearchParameters searchParameters) throws ParseException{
		
		return new ResponseEntity<List<UniverseEvent>>(universeService.findPlanets(searchParameters), HttpStatus.OK);
	}

}
