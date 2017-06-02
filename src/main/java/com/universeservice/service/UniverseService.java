package com.universeservice.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.universeservice.domain.entity.SearchParameters;
import com.universeservice.domain.entity.UniverseEvent;
import com.universeservice.domain.repository.UniverseEventRepository;

@Service
public class UniverseService {

	private final UniverseEventRepository universeEventRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UniverseService.class);

	@Autowired
	public UniverseService(final UniverseEventRepository UniverseEventRepository) {
		this.universeEventRepository = UniverseEventRepository;
	}
	
	public List<UniverseEvent> returnPingTestValue(){
		
		List<UniverseEvent> pingTestList = new ArrayList<UniverseEvent>();
		
		UniverseEvent pingTestValue = new UniverseEvent();
		pingTestValue.setDiscoveryDate(new Date());
		pingTestValue.setEventDistance(new Double("250000000"));
		pingTestValue.setEventMass(new Double("500000"));
		pingTestValue.setEventName("TestPlanet");
		pingTestValue.setEventType("TypeX");
		
		UniverseEvent pingTestValue2 = new UniverseEvent();
		pingTestValue2.setDiscoveryDate(new Date());
		pingTestValue2.setEventDistance(new Double("350000000"));
		pingTestValue2.setEventMass(new Double("600000"));
		pingTestValue2.setEventName("TestPlanet2");
		pingTestValue2.setEventType("TypeY");
		
		pingTestList.add(pingTestValue);
		pingTestList.add(pingTestValue2);
		
		return pingTestList;
	}
	
	public List<UniverseEvent> loadEventsIntoMemory(List<UniverseEvent> universeEvents){
		return universeEventRepository.save(universeEvents);
	}
	
	public List<UniverseEvent> getEventByName(String eventName){
		List<UniverseEvent> e = universeEventRepository.findByEventName(eventName);
		return e;
	}
	
	public List<UniverseEvent> getNearestEvents(){
		Page<UniverseEvent> events100Page = universeEventRepository.findNearest100(new PageRequest(0,100));
		return events100Page.getContent();
	}
	
	public List<UniverseEvent> findPlanets(SearchParameters searchParameters) throws ParseException{
		return universeEventRepository.searchPlanets(searchParameters.getEventNameParameter(), searchParameters.getEventTypeParameter(), 
				searchParameters.getUpperLimitEventDistancParameter(), searchParameters.getLowerLimitEventDistancParameter(), 
				searchParameters.getUpperLimitEventMassParameter(), searchParameters.getLowerLimitEventMassParameter(), 
				new SimpleDateFormat("yyyy-MM-dd").parse(searchParameters.getUpperLimitEventDiscoveryDateParameter()),
				new SimpleDateFormat("yyyy-MM-dd").parse(searchParameters.getLowerLimitEventDiscoveryDateParameter()));
	}

}
