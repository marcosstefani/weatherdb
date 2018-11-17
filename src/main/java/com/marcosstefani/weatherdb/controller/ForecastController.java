package com.marcosstefani.weatherdb.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alicp.jetcache.anno.Cached;
import com.marcosstefani.weatherdb.model.Forecast;
import com.marcosstefani.weatherdb.service.ForecastService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("forecasts")
public class ForecastController {

	@Autowired
	private ForecastService forecastService;

	@GetMapping(value = "/historic", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Forecast> getForecastHistoric(Pageable pageable) {
		return forecastService.getForecastHistoric(pageable);
	}
	
	@Cached(expire = 10, timeUnit = TimeUnit.MINUTES)
	@GetMapping(value = "/original-data", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFromService(@ApiParam("City's name") @RequestParam(required = true) String city) {
		return forecastService.getFromService(city);
	}
	
	@PostMapping(value = "/load", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> uploadFromService(String city) {
		return forecastService.uploadFromService(city);
	}
	
	@Scheduled(fixedRate = 60000)
	@PostMapping(value = "/messages")
	public void sendMesssagesToUpload() {
		forecastService.sendMessagesToUpload();
	}

}
