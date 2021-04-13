package com.web.restservice.controllers;

import com.web.restservice.entities.RequestCounter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController{
    @GetMapping("/getcounter")
    public String outCounter(Model model){
        model.addAttribute("counter", "Было выполнено  " + RequestCounter.INSTANCE.getCounter() +" запросов на главный контроллер");

        return "counter";
    }

}
