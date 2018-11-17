package com.marcosstefani.weatherdb.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class Wind implements Serializable {

	private static final long serialVersionUID = -5739218539184084092L;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal speed;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal deg;

	public BigDecimal getSpeed() {
		return speed;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	public BigDecimal getDeg() {
		return deg;
	}

	public void setDeg(BigDecimal deg) {
		this.deg = deg;
	}

}
