package com.marcosstefani.weatherdb.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name = "city")
@JacksonXmlRootElement
public class City implements Serializable {

	private static final long serialVersionUID = 1430796010634639846L;

	@Id
	private Integer id;

	private String name;

	@JsonProperty("coord")
	@Embedded
	private Coordinate coordinate;

	private String country;

	@Type(type = "org.hibernate.type.BigIntegerType")
	private BigInteger population;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigInteger getPopulation() {
		return population;
	}

	public void setPopulation(BigInteger population) {
		this.population = population;
	}

}
