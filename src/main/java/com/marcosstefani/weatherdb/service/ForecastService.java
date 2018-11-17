package com.marcosstefani.weatherdb.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.marcosstefani.weatherdb.dto.ForecastDTO;
import com.marcosstefani.weatherdb.messaging.WeatherQueueSender;
import com.marcosstefani.weatherdb.model.City;
import com.marcosstefani.weatherdb.model.Forecast;
import com.marcosstefani.weatherdb.repository.ForecastRepository;

import springfox.documentation.spring.web.json.Json;

@Service
public class ForecastService {
	private final String URI = "http://api.openweathermap.org/data/2.5/forecast";
	private final String API_ID = "0b4ba9ce32d3e8c1c8cda4898c290586";
	
	private final RestTemplate restTemplate;
	private static Logger logger = LoggerFactory.getLogger(ForecastService.class);

	public ForecastService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Autowired
	private ForecastRepository forecastRepository;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private WeatherQueueSender weatherQueueSender;

	public Page<Forecast> getForecastHistoric(Pageable pageable) {
		return forecastRepository.findAll(pageable);
	}
	
	public Forecast createForecast(@Valid Forecast forecast) {
		return forecastRepository.save(forecast);
	}

	public ResponseEntity<?> getFromService(String city) {
		ForecastDTO result = null;
		try {
			result = this.restTemplate.getForObject(this.url(city), ForecastDTO.class);
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<>(new Json(e.getResponseBodyAsString()), e.getStatusCode());
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<?> uploadFromService(String city) {
		logger.info(String.format("Sending city %s", city));
		ResponseEntity<?> result = this.getFromService(city);
		List<Forecast> saved = new ArrayList<Forecast>();
		
		if (HttpStatus.OK.equals(result.getStatusCode())) {
			ForecastDTO dto = (ForecastDTO) result.getBody();
			cityService.createCity(dto.getCity());
			
			for (Forecast forecast : dto.getList()) {
				forecast.setCityId(dto.getCity().getId());
				forecast.setCity(dto.getCity());
				saved.add(this.createForecast(forecast));
			}
		}
		else {
			return result;
		}
		logger.info(String.format("Saving %d registers", saved.size()));
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	private String url(String city) {
		return String.format(URI.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, API_ID);
	}

	public void sendMessagesToUpload() {
		List<City> cities = cityService.findAll();
		cities.forEach(city -> {
			String cityName = city.getName();
			logger.info(String.format("Sending Message for city %s", cityName));
			weatherQueueSender.send(cityName);
		});
	}

}
