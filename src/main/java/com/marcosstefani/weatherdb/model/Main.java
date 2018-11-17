package com.marcosstefani.weatherdb.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class Main implements Serializable {

	private static final long serialVersionUID = -5479635950229231867L;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal temp;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal temp_min;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal temp_max;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal pressure;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal sea_level;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal grnd_level;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal humidity;

	@Type(type = "org.hibernate.type.BigDecimalType")
	private BigDecimal temp_kf;

	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	public BigDecimal getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(BigDecimal temp_min) {
		this.temp_min = temp_min;
	}

	public BigDecimal getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(BigDecimal temp_max) {
		this.temp_max = temp_max;
	}

	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public BigDecimal getSea_level() {
		return sea_level;
	}

	public void setSea_level(BigDecimal sea_level) {
		this.sea_level = sea_level;
	}

	public BigDecimal getGrnd_level() {
		return grnd_level;
	}

	public void setGrnd_level(BigDecimal grnd_level) {
		this.grnd_level = grnd_level;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTemp_kf() {
		return temp_kf;
	}

	public void setTemp_kf(BigDecimal temp_kf) {
		this.temp_kf = temp_kf;
	}

}
