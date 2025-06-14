package com.test.my_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
public class UppercaseController {

    @Autowired
    private Function<String, String> uppercase; 

    @GetMapping("/uppercase")
    public String convert(@RequestParam String input) {
        return uppercase.apply(input);
    }
}