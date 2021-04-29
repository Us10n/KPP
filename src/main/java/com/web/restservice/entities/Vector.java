package com.web.restservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Vector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer x1;
    private Integer x2;
    private Integer y1;
    private Integer y2;
    private Double Norma;
    private Integer projection_x;
    private Integer projection_y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(x1, vector.x1) && Objects.equals(x2, vector.x2) && Objects.equals(y1, vector.y1) && Objects.equals(y2, vector.y2) && Objects.equals(Norma, vector.Norma) && Objects.equals(projection_x, vector.projection_x) && Objects.equals(projection_y, vector.projection_y);
    }

    public Vector() {
    }

    public Long getId() {
        return id;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNorma() {
        return Norma;
    }

    public Integer getProjection_x() {
        return projection_x;
    }

    public Integer getProjection_y() {
        return projection_y;
    }

    public Vector(Integer x1, Integer y1, Integer x2, Integer y2) {
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
