package com.web.restservice.entities;

public class VectorBody {
    private Integer x1;
    private Integer x2;
    private Integer y1;
    private Integer y2;

    public VectorBody(Integer x1, Integer x2, Integer y1, Integer y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Integer getX1() {
        return x1;
    }

    public Integer getX2() {
        return x2;
    }

    public Integer getY1() {
        return y1;
    }

    public Integer getY2() {
        return y2;
    }
}
