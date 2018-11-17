# weatherdb
Example code developed with Spring Boot using RestFul and database mapping

The messaging service used was RabbitMQ, I installed it in a local Docker that can be accessed by the address http://localhost:32784

## WeatherConsumer
@Component: The consumer must be a bean mapped in Spring, so annotated as a component;
@RabbitListener: It is the annotation that marks the method as a listener;
@Payload: It is the annotation that informs that the parameter will receive the body of the message. Note: This is not required when you have only one parameter.


## WeatherQueueSender
RabbitTemplate: It is a helper class to synchronously access and send messages to RabbitMQ;
Queue: An object representing the configured queue;
rabbitTemplate.convertAndSend: Method has received the parameters: routingKey and message, where are the name of the file and the message to be sent.


## ForecastController
10 minutes cache for the getFromService method