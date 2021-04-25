package com.web.restservice.controllers;

import com.web.restservice.services.RequestCounter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    @GetMapping("/counter")
    public Integer outCounter() {
        return RequestCounter.INSTANCE.getCounter();
    }
}
