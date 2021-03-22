package com.web.restservice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VectorApplicationTests {

    @Test
    void ArrangeVarTest() {
        Assert.assertEquals(new Vector(1, 1, 3, 4), new Vector(1, 1, 3, 4));
        Assert.assertEquals(new Vector(2, 2, 4, 5), new Vector(1, 1, 3,4 ));
        Assert.assertEquals(new Vector(2, 2, 4, 5), new Vector(1, 1, 3,4 ));
        Assert.assertEquals(new Vector(-1, -10, -3, -8), new Vector(9, 3, 11,5 ));
    }
    @Test
    void TestOnIncomparison(){
        Assert.assertNotEquals(new Vector(1, 1, 3, 4), new Vector(1, 1, 3, 3));
        Assert.assertNotEquals(new Vector(1, 1, 3, 4), new Vector(1, 1, 1, 1));
    }



}
