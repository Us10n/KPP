package com.web.restservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VectorTest {

    @Test
    void VectorCompTest() {
        //Vector(x1_coordinate,y1_coordinate,x2_coordinate,y2_coordinate)
        Assertions.assertEquals(new Vector(1, 1, 3, 4), new Vector(1, 1, 3, 4));
        Assertions.assertEquals(new Vector(2, 2, 4, 5), new Vector(1, 1, 3,4 ));
        Assertions.assertEquals(new Vector(2, 2, 4, 5), new Vector(1, 1, 3,4 ));
        Assertions.assertEquals(new Vector(-1, -10, -3, -8), new Vector(9, 3, 11,5 ));
    }
}
