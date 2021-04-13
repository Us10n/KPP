package com.web.restservice.threads;

import com.web.restservice.controllers.MainController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CounterThread extends Thread {
    private long counter = 0;
    private static final Logger logger = LogManager.getLogger(MainController.class);

    public void inc() {
        ++counter;
        logger.info(counter);
    }

    public synchronized boolean isRunnable() {
        return super.isAlive() && !super.isInterrupted();
    }

    @Override
    public void run() {
        System.out.println(counter);
    }

    @Override
    public synchronized void start() {
        super.start();
    }
}
