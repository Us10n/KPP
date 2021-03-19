package com.web.restservice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VectorApplicationTests {

    @Test
    void IVectorTest() {
        Vector v1 = new Vector(1, 2, 3, 4);
        Vector v2 = new Vector(1, 1, 3, 4);

        Assert.assertEquals(new Vector(1, 2, 3, 4),new Vector(1, 2, 3, 4));
    }
    @Test
    void DVectorTest(){
        Assert.assertEquals(MainController.calculate(1, 1), 2);
    }



}
