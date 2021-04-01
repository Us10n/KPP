package com.web.restservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);
    @Autowired
    private static Cache cache=new Cache();

    @GetMapping("/")
    public Vector GetParams(@RequestParam(value = "x1", defaultValue = "0") Integer x1,
                            @RequestParam(value = "y1", defaultValue = "0") Integer y1,
                            @RequestParam(value = "x2", defaultValue = "0") Integer x2,
                            @RequestParam(value = "y2", defaultValue = "0") Integer y2) {
        Vector vector;
        vector = new Vector(x1, y1, x2, y2);


        if (cache.IsContains(vector)) {
            logger.info("Vector exists in cache");
        }
        else{
            logger.info("Vector saved in cache");
            cache.add(vector);
        }

        RequestCounter.INSTANCE.IncCounter();
        return vector;
    }
}
