package com.web.restservice;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Cache {
    private final BlockingQueue<Vector> blockingQueue = new LinkedBlockingQueue<>();

    public boolean IsContains(Vector vector) {
        return blockingQueue.contains(vector);
    }

    public boolean add(Vector vector) {
        if (!blockingQueue.contains(vector)) {
            return blockingQueue.add(vector);
        } else {
            return false;
        }
    }

}
