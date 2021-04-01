package com.web.restservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum RequestCounter {
    INSTANCE;

    private static final Logger logger = LogManager.getLogger(MainController.class);
    private Integer counter=0;

    public synchronized void IncCounter(){
        ++counter;
        logger.info(counter);
    }
}
