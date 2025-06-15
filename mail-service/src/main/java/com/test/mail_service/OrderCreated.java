package com.test.mail_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreated {
  private String orderId;
  private String productName;
  // getters, setters, constructor
}