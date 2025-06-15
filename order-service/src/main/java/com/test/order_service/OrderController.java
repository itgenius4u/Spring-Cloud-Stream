package com.test.order_service;

import java.util.UUID;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final StreamBridge streamBridge;

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestParam String productName) {
        OrderCreated order = new OrderCreated(UUID.randomUUID().toString(), productName);
        streamBridge.send("order-out-0", order); // 바인딩 이름에 맞춰 보냄
        
        return ResponseEntity.ok("Order sent: " + order.getOrderId());
    }
}