package com.web.restservice.service;

import com.web.restservice.entities.Vector;

import java.util.List;

public enum VectorService {
    INSTANCE;

    public Double calcAverageX1(List<Vector> vectorList) {
//        bodyList.stream().forEach((body)->{
//            Double mediumX=0.;
//            Integer bodyX1= body.getX1();
//            Integer bodyX2=body.getX2();
//            if (bodyX2 > bodyX1) {
//                mediumX += Math.abs(bodyX2 - bodyX1);
//            } else {
//                mediumX+= Math.abs(bodyX1 - bodyX2);
//            }
//            return mediumX;
//        });
        return vectorList.stream().
                mapToInt(Vector::getX1).average().getAsDouble();
    }

    public Double calcAverageX2(List<Vector> bodyList) {
        return bodyList.stream().
                mapToInt(Vector::getX2).average().getAsDouble();
    }

    public Double calcAverageY1(List<Vector> bodyList) {
        return bodyList.stream().
                mapToInt(Vector::getY1).average().getAsDouble();
    }

    public Double calcAverageY2(List<Vector> bodyList) {
        return bodyList.stream().
                mapToInt(Vector::getY2).average().getAsDouble();
    }

    public Double calcAverageNorma(List<Vector> bodyList) {
        return bodyList.stream().
                mapToDouble(Vector::getNorma).average().getAsDouble();
    }

    public Double calcAverageProjectionX(List<Vector> bodyList) {
        return bodyList.stream().
                mapToInt(Vector::getProjection_x).average().getAsDouble();
    }

    public Double calcAverageProjectionY(List<Vector> bodyList) {
        return bodyList.stream().
                mapToInt(Vector::getProjection_y).average().getAsDouble();
    }


}
