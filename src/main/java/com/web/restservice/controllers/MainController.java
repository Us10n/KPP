package com.web.restservice.controllers;

import com.web.restservice.entities.AverageValues;
import com.web.restservice.entities.IntermediateBody;
import com.web.restservice.entities.Vector;
import com.web.restservice.entities.VectorBody;
import com.web.restservice.services.RequestCounter;
import com.web.restservice.services.VectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@RestController
public class MainController {


    @Autowired
    private VectorService vectorService;

    @PostMapping(value = "/")
    public ResponseEntity<?> bulkParams(@RequestBody List<VectorBody> bodyList) {
        //vector save
        bodyList = vectorService.VectorSaveList(bodyList);

        List<Vector> vectorList = vectorService.convertToVectorList(bodyList);

        AverageValues values = new AverageValues();
        try {
            values.countArrangeValues(vectorList);
        } catch (Exception e) {
            return new ResponseEntity<>("500 error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
        } catch (Exception e) {
            return new ResponseEntity<>("400 error", HttpStatus.BAD_REQUEST);
        }

        Vector vector= vectorService.VectorSaveClass(vectorBody);
        RequestCounter.INSTANCE.IncCounter();
        return new ResponseEntity<>(vector, HttpStatus.OK);
    }
}
