package com.util.calculator;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator c = new Calculator();

    @Test
    public void test1(){
        assertEquals(2, c.divide(10,5));
    }

    @Test
    public void test2(){
        assertEquals(1, c.divide(5,5));
    }

    @Test
    public void test3(){
        assertNotEquals(1, c.divide(0,10));
    }

    @Test
    public void test4(){
        assertThrows(ArithmeticException.class, ()->{
            c.divide(0,0);
        });
    }
}