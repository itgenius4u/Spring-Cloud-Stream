package com.test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 인터페이스	            역할	                     형식
// Consumer<T>	    매개값을 받고 반환값 없음	    (T t) -> { ... }
// Supplier<T>	    매개값 없고 반환값만 있음	    () -> T
// Function<T, R>	매개값 T를 받아서 R을 반환	    (T t) -> R
// Predicate<T>	    매개값을 받고 boolean 반환	   (T t) -> boolean

public class ConsumerExample {
   public static void main(String[] args) {
        // Consumer<T> – 값을 받아 처리만 하고 반환 없음
        Consumer<String> printer 
            = name -> System.out.println("Hello " + name);
        printer.accept("Java #1");

        // Supplier<T> – 값을 공급 (반환만 하고 매개변수 없음)
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("랜덤값: " + randomSupplier.get());

         // Function<T, R> – 입력 값을 가공하여 반환
        Function<String, Integer> lengthFunction = str -> str.length();
        System.out.println("길이: " + lengthFunction.apply("Lambda"));

        // Predicate<T> – 조건 판단 (true/false 반환)
        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("빈 문자열인가? " + isEmpty.test(""));

        Consumer<String> printer2 = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Hello " + name);
            }
        };
        printer2.accept("Java #2");

        Consumer<String> printer3 = name -> System.out.println("Hello " + name);
        printer3.accept("Java #3");
   }
}
