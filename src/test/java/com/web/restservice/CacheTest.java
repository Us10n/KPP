package com.web.restservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTest {
    @Autowired
    private static Cache cache;

    @Test
    void CacheContainsTest() {
        cache=new Cache();
        cache.add(new Vector(1, 1, 3, 4));
        cache.add(new Vector(22, 5, 4, 3));
        cache.add(new Vector(0, 0, 0, 0));
        cache.add(new Vector(22, 5, 4, 3));

        //Vector(x1_coordinate,y1_coordinate,x2_coordinate,y2_coordinate)
        Assertions.assertTrue(cache.IsContains(new Vector(1, 1, 3, 4)));
        Assertions.assertTrue(cache.IsContains(new Vector(1, 1, 3, 4)));
        Assertions.assertTrue(cache.IsContains(new Vector(22, 5, 4, 3)));
        Assertions.assertFalse(cache.IsContains(new Vector(1, 1, 1, 2)));
        Assertions.assertFalse(cache.IsContains(new Vector(6, 8, 8, 6)));
    }

    @Test
    void CacheAddTest() {
        cache=new Cache();

        //Vector(x1_coordinate,y1_coordinate,x2_coordinate,y2_coordinate)
        Assertions.assertTrue(cache.add(new Vector(1, 1, 3, 4)));
        Assertions.assertTrue(cache.add(new Vector(22, 5, 4, 3)));
        Assertions.assertTrue(cache.add(new Vector(0, 0, 0, 0)));
        Assertions.assertFalse(cache.add(new Vector(22, 5, 4, 3)));
    }
}
