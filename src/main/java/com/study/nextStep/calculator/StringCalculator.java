package com.study.nextStep.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    public int add(String text){

        // 빈 문자열 체크
        if(text == null || text.trim().isEmpty()) {
            return 0;
        }

        try {
            int num = Integer.parseInt(text);
            checkMinus(num);
            return num;
        }
        catch(NumberFormatException e) {
            return calculateStringWithDelimiter(text);
        }
    }

    private int calculateStringWithDelimiter(String text){
        List<String> result = new ArrayList<>();
        if(hasCustomPattern(text)){
            result = getCustomPatternResult(text);
        }

        if(hasCommaOrQuotes(text)) {
            result.addAll(Arrays.stream(getCommaOrColonResult(text)).collect(Collectors.toList()));
        }

        return calculator(result);
    }

    private void checkMinus(int num) {
        if(num < 0){
            throw new RuntimeException();
        }
    }

    private boolean hasCommaOrQuotes(String text) {
        return text.contains(",") || text.contains(":");
    }

    private String[] getCommaOrColonResult(String text){
        return text.split(",|:");
    }

    private boolean hasCustomPattern(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text).find();
    }

    private List<String> getCustomPatternResult(String text){
        List<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        while(matcher.find()){
            String delimiter = matcher.group(1);
            String str = matcher.group(2);
            String[] tmp = str.split(delimiter);
            result = Arrays.stream(tmp).toList();
        }
        return result;
    }

    private int calculator(List<String> nums){
        int result = 0;
        for (String s : nums) {
            int num = Integer.parseInt(s);
            checkMinus(num);
            result += num;
        }
        return result;
    }
}
