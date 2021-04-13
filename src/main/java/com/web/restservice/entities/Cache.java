package com.web.restservice.entities;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Cache {
    private final BlockingQueue<Vector> blockingQueue = new LinkedBlockingQueue<>();
    private final ConcurrentHashMap<Integer, Vector> hashMap = new ConcurrentHashMap<>();

    public boolean IsContains(Vector vector) {
        return blockingQueue.contains(vector);
    }

    public boolean add(Vector vector) {
        return blockingQueue.add(vector);
    }

    public synchronized void put(Vector vector) {
        if (!hashMap.containsValue(vector)) {
            hashMap.put(RequestCounter.INSTANCE.getCounter(), vector);
        }
    }

    public synchronized boolean IsContains_map(Vector vector) {
        return hashMap.containsValue(vector);
    }

}
