package com.test.consumer_app;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerAppApplication.class, args);
	}
   	@Bean
    public Consumer<String> receive() {
        return message -> System.out.println(">>> Received: " + message);
    }
}
