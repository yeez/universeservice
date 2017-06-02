package com.universeservice.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "universe_event")
public class UniverseEvent implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "event_name", length = 50, nullable = false)
	private String eventName;

	@Column(name = "event_type", length = 100)
	private String eventType;

	@Column(name = "event_distance", length = 100)
	private Double eventDistance;

	@Column(name = "mass")
	private Double eventMass;

	@Temporal(TemporalType.DATE)
	@Column(name = "event_discovery_date")
	private Date eventDiscoveryDate;

	public UniverseEvent() {
	}

	public UniverseEvent(Integer id, String eventName, String eventType, Double eventDistance, Double eventMass,
			Date discoveryDate) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDistance = eventDistance;
		this.eventMass = eventMass;
		this.eventDiscoveryDate = discoveryDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Double getEventDistance() {
		return eventDistance;
	}

	public void setEventDistance(Double eventDistance) {
		this.eventDistance = eventDistance;
	}

	public Double getEventMass() {
		return eventMass;
	}

	public void setEventMass(Double eventMass) {
		this.eventMass = eventMass;
	}

	public Date getDiscoveryDate() {
		return eventDiscoveryDate;
	}

	public void setDiscoveryDate(Date discoveryDate) {
		this.eventDiscoveryDate = discoveryDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
