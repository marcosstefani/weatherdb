package com.marcosstefani.weatherdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosstefani.weatherdb.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
