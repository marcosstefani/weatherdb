package com.marcosstefani.weatherdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosstefani.weatherdb.model.City;
import com.marcosstefani.weatherdb.service.CityService;
import com.marcosstefani.weatherdb.service.ForecastService;

@RestController
@RequestMapping("cities")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@Autowired
	private ForecastService forecastService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<City> getCieties(Pageable pageable) {
		return cityService.getCieties(pageable);
	}
	
	@PostMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createCity(@PathVariable String name) {
		return forecastService.uploadFromService(name);
	}

}
