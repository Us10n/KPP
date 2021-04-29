package com.web.restservice.entities;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Cache {
    //private final BlockingQueue<Vector> blockingQueue = new LinkedBlockingQueue<>();
    private final ConcurrentHashMap<VectorBody, Vector> hashMap = new ConcurrentHashMap<>();

//    public boolean isContains(Vector vector) {
//        return blockingQueue.contains(vector);
//    }
//
//    public boolean add(Vector vector) {
//        return blockingQueue.add(vector);
//    }
//
//    public BlockingQueue<Vector> getCache() {
//        return blockingQueue;
//    }
    public synchronized void put(VectorBody vectorBody,Vector vector) {
            hashMap.put(vectorBody, vector);
    }

    public synchronized boolean isContains(VectorBody vectorBody) {
        return hashMap.containsKey(vectorBody);
    }

    public synchronized Vector get(VectorBody vectorBody){
        return hashMap.get(vectorBody);
    }



}
