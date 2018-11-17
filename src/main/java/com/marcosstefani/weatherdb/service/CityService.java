package com.marcosstefani.weatherdb.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marcosstefani.weatherdb.model.City;
import com.marcosstefani.weatherdb.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public Page<City> getCieties(Pageable pageable) {
		return cityRepository.findAll(pageable);
	}
	
	public City createCity(@Valid City city) {
		return cityRepository.save(city);
	}
	
	public List<City> findAll() {
		return cityRepository.findAll();
	}

}
