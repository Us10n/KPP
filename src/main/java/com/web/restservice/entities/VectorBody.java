package com.web.restservice.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorBody that = (VectorBody) o;
        return Objects.equals(x1, that.x1) && Objects.equals(x2, that.x2) && Objects.equals(y1, that.y1) && Objects.equals(y2, that.y2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, y1, y2);
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
