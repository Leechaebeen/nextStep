package com.study.nextStep.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator cal;

    @BeforeEach
    public void setUp() {
         cal = new Calculator();
        System.out.println("before");
    }
    
    @Test
    void add() {
        assertEquals(9, cal.add(6,3));
        System.out.println("add");
    }

    @Test
    void subtract(){
        assertEquals(3, cal.subtract(6,3));
        System.out.println("subtract");
    }

    @AfterEach
    void tearDown(){
        System.out.println("tearDown");
    }
}
