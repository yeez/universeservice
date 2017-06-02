package com.universeservice.domain.entity;

public class SearchParameters {
	
	private String eventNameParameter;
	
	private String eventTypeParameter;
	
	private Double upperLimitEventDistancParameter;
	
	private Double lowerLimitEventDistancParameter;
	
	private Double upperLimitEventMassParameter;
	
	private Double lowerLimitEventMassParameter;
	
	private String upperLimitEventDiscoveryDateParameter;
	
	private String lowerLimitEventDiscoveryDateParameter;
	
	public SearchParameters(){
		
	}

	public SearchParameters(String eventNameParameter, String eventTypeParameter,
			Double upperLimitEventDistancParameter, Double lowerLimitEventDistancParameter,
			Double upperLimitEventMassParameter, Double lowerLimitEventMassParameter,
			String upperLimitEventDiscoveryDateParameter, String lowerLimitEventDiscoveryDateParameter) {
		super();
		this.eventNameParameter = eventNameParameter;
		this.eventTypeParameter = eventTypeParameter;
		this.upperLimitEventDistancParameter = upperLimitEventDistancParameter;
		this.lowerLimitEventDistancParameter = lowerLimitEventDistancParameter;
		this.upperLimitEventMassParameter = upperLimitEventMassParameter;
		this.lowerLimitEventMassParameter = lowerLimitEventMassParameter;
		this.upperLimitEventDiscoveryDateParameter = upperLimitEventDiscoveryDateParameter;
		this.lowerLimitEventDiscoveryDateParameter = lowerLimitEventDiscoveryDateParameter;
	}

	public String getEventNameParameter() {
		return eventNameParameter;
	}

	public void setEventNameParameter(String eventNameParameter) {
		this.eventNameParameter = eventNameParameter;
	}

	public String getEventTypeParameter() {
		return eventTypeParameter;
	}

	public void setEventTypeParameter(String eventTypeParameter) {
		this.eventTypeParameter = eventTypeParameter;
	}

	public Double getUpperLimitEventDistancParameter() {
		return upperLimitEventDistancParameter;
	}

	public void setUpperLimitEventDistancParameter(Double upperLimitEventDistancParameter) {
		this.upperLimitEventDistancParameter = upperLimitEventDistancParameter;
	}

	public Double getLowerLimitEventDistancParameter() {
		return lowerLimitEventDistancParameter;
	}

	public void setLowerLimitEventDistancParameter(Double lowerLimitEventDistancParameter) {
		this.lowerLimitEventDistancParameter = lowerLimitEventDistancParameter;
	}

	public Double getUpperLimitEventMassParameter() {
		return upperLimitEventMassParameter;
	}

	public void setUpperLimitEventMassParameter(Double upperLimitEventMassParameter) {
		this.upperLimitEventMassParameter = upperLimitEventMassParameter;
	}

	public Double getLowerLimitEventMassParameter() {
		return lowerLimitEventMassParameter;
	}

	public void setLowerLimitEventMassParameter(Double lowerLimitEventMassParameter) {
		this.lowerLimitEventMassParameter = lowerLimitEventMassParameter;
	}

	public String getUpperLimitEventDiscoveryDateParameter() {
		return upperLimitEventDiscoveryDateParameter;
	}

	public void setUpperLimitEventDiscoveryDateParameter(String upperLimitEventDiscoveryDateParameter) {
		this.upperLimitEventDiscoveryDateParameter = upperLimitEventDiscoveryDateParameter;
	}

	public String getLowerLimitEventDiscoveryDateParameter() {
		return lowerLimitEventDiscoveryDateParameter;
	}

	public void setLowerLimitEventDiscoveryDateParameter(String lowerLimitEventDiscoveryDateParameter) {
		this.lowerLimitEventDiscoveryDateParameter = lowerLimitEventDiscoveryDateParameter;
	}
	
}
