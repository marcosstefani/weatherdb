package com.marcosstefani.weatherdb;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
public class WeatherdbApplication {
	
	@Value("${queue.weather.name}")
    private String weatherQueue;

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/api/v1");
		SpringApplication.run(WeatherdbApplication.class, args);
	}
	
	@Bean
    public Queue queue() {
        return new Queue(weatherQueue, true);
    }
	
}
