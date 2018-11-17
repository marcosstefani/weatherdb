package com.marcosstefani.weatherdb.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.marcosstefani.weatherdb.service.ForecastService;

@Component
public class WeatherConsumer {
	
	@Autowired
	private ForecastService forecastService;
	
	@RabbitListener(queues = {"${queue.weather.name}"})
    public void receive(@Payload String cityName) {
       forecastService.uploadFromService(cityName);
    }

}
