package com.test.mail_service;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}
	@Bean
	public Consumer<OrderCreated> mailConsumer() {
		return order -> System.out.println("주문 확인 메일 전송: " + order.getOrderId());
	}


}
