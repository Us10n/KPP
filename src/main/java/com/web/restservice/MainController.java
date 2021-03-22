package com.web.restservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    @GetMapping("/")
    public Vector GetParams(@RequestParam(value = "x1", defaultValue = "0") Integer x1,
                            @RequestParam(value = "y1", defaultValue = "0") Integer y1,
                            @RequestParam(value = "x2", defaultValue = "0") Integer x2,
                            @RequestParam(value = "y2", defaultValue = "0") Integer y2) {
        try {
            String abc = null;
            abc.equals("hello");
        }catch (NullPointerException e){
            logger.error(e.getMessage());
        }
        logger.info("Successfully got params");
        return new Vector(x1, y1, x2, y2);
    }
    private static Logger logger = LogManager.getLogger(MainController.class);
}
