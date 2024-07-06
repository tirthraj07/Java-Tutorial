package com.learning;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PurchasedCourseTest {
    PurchasedCourse pc = new PurchasedCourse();

    @Test
    void testJavaCoursePurchase(){
        assertTrue(pc.proceedWithPurchase(new JavaCourse()));
    }

    @Test
    void testSpringBootCoursePurchase(){
        assertTrue(pc.proceedWithPurchase(new SpringBootCourse()));
    }

    @Test
    void testJDBCCoursePurchase(){
        assertTrue(pc.proceedWithPurchase(new JdbcCourse()));
    }


}