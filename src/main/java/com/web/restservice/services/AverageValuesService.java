package com.web.restservice.services;

import com.web.restservice.entities.Vector;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.OptionalDouble;

@Component
public class AverageValuesService {

    public Double calcAverageX1(List<Vector> vectorList) {
        OptionalDouble oDouble=vectorList.stream().
                mapToInt(Vector::getX1).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
//        if(oDouble.isPresent()){
////        return oDouble.getAsDouble();
////        }
////        else {
////            return null;
////        }
    }

    public Double calcAverageX2(List<Vector> vectorList) {
        OptionalDouble oDouble=vectorList.stream().
                mapToInt(Vector::getX2).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

    public Double calcAverageY1(List<Vector> vectorList) {
        OptionalDouble oDouble=vectorList.stream().
                mapToInt(Vector::getY1).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

    public Double calcAverageY2(List<Vector> vectorList) {
        OptionalDouble oDouble=vectorList.stream().
                mapToInt(Vector::getY2).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

    public Double calcAverageNorma(List<Vector> vectorList) {
        OptionalDouble oDouble=vectorList.stream().
                mapToDouble(Vector::getNorma).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

    public Double calcAverageProjectionX(List<Vector> vectorList) {
        OptionalDouble oDouble=vectorList.stream().
                mapToInt(Vector::getProjection_x).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

    public Double calcAverageProjectionY(List<Vector> vectorList) {
        OptionalDouble oDouble=vectorList.stream().
                mapToInt(Vector::getProjection_y).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }
}
