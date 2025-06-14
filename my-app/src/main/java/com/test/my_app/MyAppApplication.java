package com.test.my_app;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

    @Bean
    public Function<String, String> uppercase() {
        return message -> {
            System.out.println("Received: " + message);
            return message.toUpperCase();
        };
    }
}
