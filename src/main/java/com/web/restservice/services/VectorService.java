package com.web.restservice.services;

import com.web.restservice.entities.Vector;
import com.web.restservice.entities.VectorBody;
import com.web.restservice.repository.VectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
@Service
public class VectorService {
    @Autowired
    VectorRepo vectorRepo;

    public Double calcAverageX1(List<Vector> vectorList) {
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

    public Vector dbVectorFind(VectorBody vectorBody) throws Exception{
        Vector vector=vectorRepo.findVectorByX1AndX2AndY1AndY2(vectorBody.getX1(), vectorBody.getX2(), vectorBody.getY1(), vectorBody.getY2());
        return vector;
    }


}
