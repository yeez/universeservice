package com.universeservice.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.universeservice.domain.entity.UniverseEvent;


public interface UniverseEventRepository extends JpaRepository<UniverseEvent, Integer>{
	
	List<UniverseEvent> findByEventName(String eventName);
	
	@Query(value = "SELECT event FROM UniverseEvent event "
		        +  "ORDER BY event_distance")
	Page<UniverseEvent> findNearest100(Pageable pageable);
	
	@Query(value = "SELECT event FROM UniverseEvent event"
	        +  " WHERE upper(event.eventName) LIKE upper(?1)"
	        +  " OR upper(event.eventType) LIKE upper(?2)"
	        +  " OR event.eventDistance BETWEEN (?4) AND (?3)"
	        +  " OR event.eventMass BETWEEN (?6) AND (?5)"
	        +  " OR event.eventDiscoveryDate BETWEEN (?8) AND (?7)")
	List<UniverseEvent> searchPlanets(String eventNameParameter, String eventTypeParameter, Double upperLimitEventDistanceParameter, 
			Double lowerLimitEventDistanceParameter, Double upperLimitEventMassParameter, Double lowerLimitEventMassParameter, 
			Date upperLimitEventDiscoveryDateParameter, Date lowerLimitEventDiscoveryDateParameter);

}
