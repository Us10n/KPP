package com.web.restservice.controllers;

import com.web.restservice.entities.*;
import com.web.restservice.repository.VectorRepo;
import com.web.restservice.services.RequestCounter;
import com.web.restservice.services.VectorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);
    @Autowired
    private VectorRepo vectorRepo;

    @Autowired
    private Cache cache;

    @Autowired
    private  VectorService vectorService;

    @GetMapping("/")
    public ResponseEntity<?> find(){
        Vector vector=vectorRepo.findVectorByX1AndX2AndY1AndY2(3,2,1,5);
        if(vector != null){
            return new ResponseEntity<>(vector,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Vector was not found", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> bulkParams(@RequestBody List<IntermidiateBody> bodyList) {
        if(bodyList.isEmpty()){
            return new ResponseEntity<>("400 error", HttpStatus.BAD_REQUEST);
        }
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
            Vector vector;
            if (cache.isContains(tmp)) {
                logger.info("Vector exists in cache");
                vector=cache.get(tmp);
            } else {
                logger.info("Vector saved in cache");
                vector=new Vector(tmp.getX1(), tmp.getY1(), tmp.getX2(), tmp.getY2());
                cache.put(tmp,vector);
            }
        });

        List<Vector> vectorList = vectorBodyList.stream()
                .map((body)-> new Vector(body.getX1(), body.getY1(), body.getX2(), body.getY2()))
                .collect(Collectors.toList());
        AverageValues values = new AverageValues(vectorService.calcAverageX1(vectorList), vectorService.calcAverageX2(vectorList),
                vectorService.calcAverageY1(vectorList), vectorService.calcAverageY2(vectorList),
                vectorService.calcAverageNorma(vectorList), vectorService.calcAverageProjectionX(vectorList),
                vectorService.calcAverageProjectionY(vectorList));

        RequestCounter.INSTANCE.IncCounter();
        return new ResponseEntity<>(values, HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<?> getParams(@RequestParam(value = "x1", defaultValue = "0") String x1,
                                       @RequestParam(value = "y1", defaultValue = "0") String y1,
                                       @RequestParam(value = "x2", defaultValue = "0") String x2,
                                       @RequestParam(value = "y2", defaultValue = "0") String y2) {
        VectorBody vectorBody;
        try {
            vectorBody = new VectorBody(Integer.parseInt(x1.trim()), Integer.parseInt(x2.trim()),
                    Integer.parseInt(y1.trim()), Integer.parseInt(y2.trim()));
        }catch (Exception e){
            return new ResponseEntity<>("400 error", HttpStatus.BAD_REQUEST);
        }
        Vector vector;
        if (cache.isContains(vectorBody)) {
            logger.info("Vector exists in cache");
            vector=cache.get(vectorBody);
        } else {
            try{
                vector = vectorService.dbVectorFind(vectorBody);
            }catch (Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
            if (vector != null) {
                logger.info("Vector exists in db");
            } else {
                logger.info("Vector saved in db and cache");
                vector=new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2());
                vectorRepo.save(vector);
            }
            logger.info("Vector saved cache");
            cache.put(vectorBody,vector);
        }
        RequestCounter.INSTANCE.IncCounter();
        return new ResponseEntity<>(vector, HttpStatus.OK);
    }
}





