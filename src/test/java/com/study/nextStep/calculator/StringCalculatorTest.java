package com.study.nextStep.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void sendEmpty(){
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void sendNull(){
        assertEquals(0, stringCalculator.add(null));
    }

    @Test
    void sendOneLength(){
        assertEquals(5, stringCalculator.add("5"));
    }

    @Test
    void sendComma(){
        assertEquals(6,stringCalculator.add("2,2,2"));
    }

    @Test
    void sendColon(){
        assertEquals(6, stringCalculator.add("2:3:1"));
    }

    @Test
    void sendCustom(){
        assertEquals(10, stringCalculator.add("//;\n5;3;2"));
    }

    @Test
    void sendMinus(){
        assertThrows(RuntimeException.class, () -> {
            stringCalculator.add("-10,2,3");
        });
    }


}
