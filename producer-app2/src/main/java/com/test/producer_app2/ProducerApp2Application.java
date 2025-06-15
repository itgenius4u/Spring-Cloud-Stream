package com.test.producer_app2;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApp2Application.class, args);
	}
	@Bean
	public Supplier<String> timeSupplier() {
		return () -> LocalDateTime.now().toString();
	}
}
