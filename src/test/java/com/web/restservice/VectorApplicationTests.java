package com.web.restservice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VectorApplicationTests {

    @Test
    void VectorTest() {
        Assert.assertEquals(new Vector(1, 1, 3, 4), new Vector(1, 1, 3, 4));
        Assert.assertNotEquals(new Vector(1, 1, 3, 4), new Vector(1, 1, 1, 1));
    }
    @Test
    void IntTest(){

    }



}
