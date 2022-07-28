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
    void sendOneLength(){
        assertEquals(5, stringCalculator.add("5"));
    }

    @Test
    void sendComma(){
        assertEquals(4,stringCalculator.add("2,2"));
    }

    @Test
    void sendQuotes(){
        assertEquals(5, stringCalculator.add("2;3"));
    }

    @Test
    void sendCustom(){
        assertEquals(8, stringCalculator.add("//*\n5*3"));
    }

    @Test
    void sendMinus(){
        assertThrows(RuntimeException.class, () -> {
            stringCalculator.add("-1");
        });
    }


}
