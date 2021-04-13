package com.web.restservice.controllers;

import com.web.restservice.interfaces.Checked;
import com.web.restservice.interfaces.CounterAction;
import com.web.restservice.entities.Cache;
import com.web.restservice.entities.Vector;
import com.web.restservice.threads.CounterThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);

    static CounterThread counterThread = new CounterThread();
    CounterAction action = new ActionController(counterThread);

    @Autowired
    private Cache cache;


    @GetMapping("/")
    public String main() {
        return "main";

    }

    /*@PostMapping("/")
    public String bulkParams(@RequestParam(value="ch1",defaultValue = "false") Boolean ch1, @RequestParam("txt1") String txt1,
                             @RequestParam(value="ch2",defaultValue = "false") Boolean ch2, @RequestParam("txt2") String txt2,
                             @RequestParam(value="ch3",defaultValue = "false") Boolean ch3, @RequestParam("txt3") String txt3,
                             @RequestParam(value="ch4",defaultValue = "false") Boolean ch4, @RequestParam("txt4") String txt4,
                             @RequestParam(value="ch5",defaultValue = "false") Boolean ch5, @RequestParam("txt5") String txt5){


        return  "main";
    }*/

    @PostMapping("/")
    public String bulkParams(@RequestParam Map<String, String> map) {
        //public String bulkParams(@RequestBody String[] strings){

        Checked checked = () ->{

        };
        return "main";
    }

    @GetMapping("/input")
    public String getParams(@RequestParam(value = "x1", defaultValue = "0") Integer x1,
                            @RequestParam(value = "y1", defaultValue = "0") Integer y1,
                            @RequestParam(value = "x2", defaultValue = "0") Integer x2,
                            @RequestParam(value = "y2", defaultValue = "0") Integer y2,
                            Model model) {

        Vector vector = new Vector(x1, y1, x2, y2);
        //Check wether add in cache is needed
        if (cache.IsContains(vector)) {
            logger.info("Vector exists in cache");
        } else {
            logger.info("Vector saved in cache");
            cache.add(vector);
        }
        //Check wether CounterThread is runnable
        if (action.isRunnable()) {
            action.start();
            action.inc();
        } else {
            action.inc();
        }
        model.addAttribute("norma", "Норма вектора = " + vector.getNorma());
        model.addAttribute("x_projection", "Проекция вектора на ось Х = " + vector.getProjection_x());
        model.addAttribute("y_projection", "Проекция вектора на ось Y = " + vector.getProjection_y());
        //RequestCounter.INSTANCE.IncCounter();
        return "vector";
    }
}



