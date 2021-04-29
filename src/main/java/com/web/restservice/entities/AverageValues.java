package com.web.restservice.entities;

import com.web.restservice.services.AverageValuesService;

import java.util.List;

public class AverageValues {

    private AverageValuesService valuesService = new AverageValuesService();

    Double AverageX1;
    Double AverageX2;
    Double AverageY1;
    Double AverageY2;
    Double AverageNorma;
    Double AverageXProjection;
    Double AverageYProjection;

    public AverageValues() {
    }

    public void countArrangeValues(List<Vector> vectorList) {
        this.AverageX1 = valuesService.calcAverageX1(vectorList);
        this.AverageX2 = valuesService.calcAverageX2(vectorList);
        this.AverageY1 = valuesService.calcAverageY1(vectorList);
        this.AverageY2 = valuesService.calcAverageY2(vectorList);
        this.AverageNorma = valuesService.calcAverageNorma(vectorList);
        this.AverageXProjection = valuesService.calcAverageProjectionX(vectorList);
        this.AverageYProjection = valuesService.calcAverageProjectionY(vectorList);
    }

    public Double getAverageNorma() {
        return AverageNorma;
    }

    public Double getAverageXProjection() {
        return AverageXProjection;
    }

    public Double getAverageYProjection() {
        return AverageYProjection;
    }

    public void setAverageNorma(Double averageNorma) {
        AverageNorma = averageNorma;
    }

    public void setAverageXProjection(Double averageXProjection) {
        AverageXProjection = averageXProjection;
    }

    public void setAverageYProjection(Double averageYProjection) {
        AverageYProjection = averageYProjection;
    }

    public Double getAverageX1() {
        return AverageX1;
    }

    public void setAverageX1(Double averageX1) {
        AverageX1 = averageX1;
    }

    public Double getAverageX2() {
        return AverageX2;
    }

    public void setAverageX2(Double averageX2) {
        AverageX2 = averageX2;
    }

    public Double getAverageY1() {
        return AverageY1;
    }

    public void setAverageY1(Double averageY1) {
        AverageY1 = averageY1;
    }

    public Double getAverageY2() {
        return AverageY2;
    }

    public void setAverageY2(Double averageY2) {
        AverageY2 = averageY2;
    }

    public AverageValues(Double averageX1, Double averageX2, Double averageY1, Double averageY2, Double averageNorma, Double averageXProjection, Double averageYProjection) {
        this.AverageX1 = averageX1;
        this.AverageX2 = averageX2;
        this.AverageY1 = averageY1;
        this.AverageY2 = averageY2;
        this.AverageNorma = averageNorma;
        this.AverageXProjection = averageXProjection;
        this.AverageYProjection = averageYProjection;
    }
}
