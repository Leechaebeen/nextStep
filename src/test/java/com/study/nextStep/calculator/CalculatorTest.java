package com.study.nextStep.calculator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator cal = new Calculator();
        assertEquals(9, cal.add(6,3));
        assertEquals(3, cal.subtract(6,3));
    }
}
