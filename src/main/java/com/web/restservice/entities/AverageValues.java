package com.web.restservice.entities;

public class AverageValues {
    Double AverageX1;
    Double AverageX2;
    Double AverageY1;
    Double AverageY2;
    Double AverageNorma;
    Double AverageXProjection;
    Double AverageYProjection;

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

    public AverageValues(Double averageX1, Double averageX2, Double averageY1, Double averageY2,Double averageNorma, Double averageXProjection,Double averageYProjection) {
        this.AverageX1 = averageX1;
        this.AverageX2 = averageX2;
        this.AverageY1 = averageY1;
        this.AverageY2 = averageY2;
        this.AverageNorma=averageNorma;
        this.AverageXProjection=averageXProjection;
        this.AverageYProjection=averageYProjection;
    }
}
