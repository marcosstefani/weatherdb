package com.marcosstefani.weatherdb.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.marcosstefani.weatherdb.model.City;
import com.marcosstefani.weatherdb.model.Forecast;

@JacksonXmlRootElement
public class ForecastDTO {
	
	private String cod;

	private BigDecimal message;

	private Integer cnt;
	
	@JacksonXmlProperty(localName = "list")
	@JacksonXmlElementWrapper(localName = "list", useWrapping = true)
	private List<Forecast> list;
	
	private City city;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public BigDecimal getMessage() {
		return message;
	}

	public void setMessage(BigDecimal message) {
		this.message = message;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public List<Forecast> getList() {
		return list;
	}

	public void setList(List<Forecast> list) {
		this.list = list;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
