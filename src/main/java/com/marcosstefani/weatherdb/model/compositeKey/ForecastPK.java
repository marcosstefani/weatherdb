package com.marcosstefani.weatherdb.model.compositeKey;

import java.io.Serializable;

public class ForecastPK implements Serializable {

	private static final long serialVersionUID = 5139089550793266114L;

	private Integer cityId;

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

	private Integer dtId;

}
