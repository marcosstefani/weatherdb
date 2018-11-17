package com.marcosstefani.weatherdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosstefani.weatherdb.model.Forecast;
import com.marcosstefani.weatherdb.model.compositeKey.ForecastPK;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, ForecastPK> {

}
