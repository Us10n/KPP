package com.web.restservice.repository;

import com.web.restservice.entities.Vector;
import org.springframework.data.repository.CrudRepository;

public interface VectorRepo extends CrudRepository<Vector, Long> {
    Vector findVectorByX1AndX2AndY1AndY2(Integer x1,Integer x2,Integer y1, Integer y2);
}
