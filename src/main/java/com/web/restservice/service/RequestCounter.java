package com.web.restservice.service;

import com.web.restservice.controllers.MainController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public enum RequestCounter {
    INSTANCE;
    Semaphore semaphore = new Semaphore(1);

    private static final Logger logger = LogManager.getLogger(MainController.class);
    private Integer counter=0;

    public synchronized void IncCounter(){
        try {
            semaphore.acquire();
            ++counter;
            logger.info(counter);
        } catch (InterruptedException e) {
            System.out.println("Semaphore error corrupted");
        }
        finally {
            semaphore.release();
        }

    }
    public synchronized Integer getCounter(){
        return counter;
    }
}
