package org.example;

import com.util.calculator.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = calc.divide(10,2);
        System.out.println("Result : "+result);
    }
}