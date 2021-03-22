package com.web.restservice;

import java.util.Objects;

public class Vector {
    public Integer x1;
    public Integer x2;
    public Integer y1;
    public Integer y2;
    public Double Norma;
    public Integer projection_x;
    public Integer projection_y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(Norma, vector.Norma) && Objects.equals(projection_x, vector.projection_x) && Objects.equals(projection_y, vector.projection_y);
    }

    Vector(Integer x1, Integer y1, Integer x2, Integer y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        if (x2 > x1) {
            this.projection_x = Math.abs(x2 - x1);
        } else {
            this.projection_x = Math.abs(x1 - x2);
        }
        if (y2 > y1) {
            this.projection_y = Math.abs(y2 - y1);
        } else {
            this.projection_y = Math.abs(y1 - y2);
        }
        this.Norma = Math.sqrt(Math.pow(this.projection_x, 2) + Math.pow(projection_y, 2));
    }


}
