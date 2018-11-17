package com.marcosstefani.weatherdb.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class Coordinate implements Serializable {

	private static final long serialVersionUID = -2758581471427802120L;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal lat;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal lon;

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

}
