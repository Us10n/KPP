package com.web.restservice.entities;

public class IntermediateBody {
    private String x1="0";
    private String x2="0";
    private String y1="0";
    private String y2="0";

    public IntermediateBody(String x1, String x2, String y1, String y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public String getX1() {
        return x1;
    }

    public String getX2() {
        return x2;
    }

    public String getY1() {
        return y1;
    }

    public String getY2() {
        return y2;
    }
}
