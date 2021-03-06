package com.marcosstefani.weatherdb.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherQueueSender {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue queue;
 
    public void send(String cityName) {
        rabbitTemplate.convertAndSend(this.queue.getName(), cityName);
    }

}
