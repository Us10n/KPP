package com.web.restservice.controllers;

import com.web.restservice.entities.*;
import com.web.restservice.service.RequestCounter;
import com.web.restservice.service.VectorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;


@RestController
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    private Cache cache;

    @GetMapping("/")
    public BlockingQueue<Vector> main() {
        return cache.getCache();
    }

    @GetMapping("/counter")
    public Integer outCounter() {
        return RequestCounter.INSTANCE.getCounter();
    }

    @PostMapping(value = "/")
//    public ResponseEntity<?> bulkParams(@RequestBody List<VectorBody> vectorBodyList) {
    public ResponseEntity<?> bulkParams(@RequestBody List<IntermidiateBody> bodyList) {
        List<VectorBody> vectorBodyList = new LinkedList<>();
        for (IntermidiateBody tmp : bodyList) {
            try {
                vectorBodyList.add(new VectorBody(Integer.parseInt(tmp.getX1().trim()), Integer.parseInt(tmp.getX2().trim()),
                        Integer.parseInt(tmp.getY1().trim()), Integer.parseInt(tmp.getY2().trim())));
            } catch (Exception e) {
                return new ResponseEntity<>("400 error", HttpStatus.BAD_REQUEST);
            }

        }

        vectorBodyList.forEach((tmp) -> {
            Vector vec = new Vector(tmp.getX1(), tmp.getY1(), tmp.getX2(), tmp.getY2());
            if (cache.isContains(vec)) {
                logger.info("Vector exists in cache");
            } else {
                logger.info("Vector saved in cache");
                cache.add(vec);
            }
        });
        List<Vector> vectorList = vectorBodyList.stream()
                .map((body) -> new Vector(body.getX1(), body.getY1(), body.getX2(), body.getY2()))
                .collect(Collectors.toList());
        AverageValues values = new AverageValues(VectorService.INSTANCE.calcAverageX1(vectorList), VectorService.INSTANCE.calcAverageX2(vectorList),
                VectorService.INSTANCE.calcAverageY1(vectorList), VectorService.INSTANCE.calcAverageY2(vectorList),
                VectorService.INSTANCE.calcAverageNorma(vectorList), VectorService.INSTANCE.calcAverageProjectionX(vectorList),
                VectorService.INSTANCE.calcAverageProjectionY(vectorList));
        return new ResponseEntity<>(values, HttpStatus.OK);
    }

    @GetMapping("/input")
    public ResponseEntity<?> getParams(@RequestParam(value = "x1", defaultValue = "0") String x1,
                                       @RequestParam(value = "y1", defaultValue = "0") String y1,
                                       @RequestParam(value = "x2", defaultValue = "0") String x2,
                                       @RequestParam(value = "y2", defaultValue = "0") String y2) {
        Vector vector;
        try {
            vector = new Vector(Integer.parseInt(x1.trim()), Integer.parseInt(y1.trim()), Integer.parseInt(x2.trim()), Integer.parseInt(y2.trim()));
        } catch (Exception e) {
            return new ResponseEntity<>("400 error", HttpStatus.BAD_REQUEST);
        }

        if (cache.isContains(vector)) {
            logger.info("Vector exists in cache");
        } else {
            logger.info("Vector saved in cache");
            cache.add(vector);
        }

        RequestCounter.INSTANCE.IncCounter();
        return new ResponseEntity<>(vector, HttpStatus.OK);
    }
}



