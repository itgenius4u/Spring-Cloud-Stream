package com.test.consumer_app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApp2Application.class, args);
	}
	@Bean
	public Consumer<String> timeConsumer() {
		return time -> System.out.println("Consumed: " + time);
	}


}
