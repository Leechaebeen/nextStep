package com.study.nextStep.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 요구사항
 * 1. 쉼표 또는 콜론을 구분자로 가지는 경우 분리한 숫자의 합을 반환
 * 2. 커스텀 구분자 사용 가능. 커스텀 구분자는 // 와 \n 사이의 값
 * 3. 음수를 입력받은 경우 RuntimeException 으로 예외처리
 * */

public class StringCalculator {

    /**
     * add() 에서 모든 요구사항을 구현해야 한다.
     * 여러 개의 메소드를 추가해야 하는 부분은 각 단위 별로 테스트 메소드를 만들어 구현한다.
     * */
    int add(String text){
        // 빈 문자열 처리
        if(text.isEmpty()){
            return 0;
        }

        // 음수 처리
        if(Integer.parseInt(text) < 0){
            throw new RuntimeException();
        }

        // 숫자 하나가 문자열로 들어온 경우 integer 로 파싱
        if(text.length() == 1){
            return Integer.parseInt(text);
        }

        if(text.contains(",") || text.contains(";") ){
            // 쉼표 또는 따옴표로 입력할 경우 두 수의 합 반환
            String[] tokens = text.split(",|;");
            int result = 0;
            for (String s : tokens) {
                result += Integer.parseInt(s);
            }
            return result;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            int result = 0;
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            for (String s : tokens) {
                result += Integer.parseInt(s);
            }
            return result;
        }

        return 0;
    }


}
