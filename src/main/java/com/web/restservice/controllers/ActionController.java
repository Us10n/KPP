package com.web.restservice.controllers;

import com.web.restservice.interfaces.CounterAction;
import com.web.restservice.threads.CounterThread;

public class ActionController implements CounterAction {
    private CounterThread counterThread;

    public ActionController(CounterThread counterThread) {
        this.counterThread = counterThread;
    }

    @Override
    public void inc() {
        counterThread.inc();
    }

    @Override
    public boolean isRunnable(){
        return counterThread.isRunnable();
    }

    @Override
    public void start(){
        counterThread.start();
    }

}
