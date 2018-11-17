package com.marcosstefani.weatherdb.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcosstefani.weatherdb.model.compositeKey.ForecastPK;

@Entity
@Table(name = "forecast")
@IdClass(ForecastPK.class)
public class Forecast implements Serializable {

	private static final long serialVersionUID = 5020374253419477722L;

	@Id
	@JsonIgnore
	@Column(name = "city_id")
	private Integer cityId;

	@Id
	@JsonProperty("dt")
	@Column(name = "dt_id")
	private Integer dtId;

	@ManyToOne
	@JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
	private City city;

	@Embedded
	private Main main;

	@Embedded
	private Wind wind;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("dt_txt")
	private LocalDateTime dhForecast;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDtId() {
		return dtId;
	}

	public void setDtId(Integer dtId) {
		this.dtId = dtId;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public LocalDateTime getDhForecast() {
		return dhForecast;
	}

	public void setDhForecast(LocalDateTime dhForecast) {
		this.dhForecast = dhForecast;
	}

}
