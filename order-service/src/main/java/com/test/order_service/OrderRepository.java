package com.test.order_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository 
    extends JpaRepository<OrderCreated, String> {}
