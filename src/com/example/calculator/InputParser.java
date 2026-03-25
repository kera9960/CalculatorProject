package com.example.calculator;

public class InputParser {
    public Double toDouble(String inputString){
        Double inputNum;
        try {
             inputNum = Double.parseDouble(inputString);
        }catch (NumberFormatException e){
            throw new NumberFormatException("숫자를 입력하세요");
        }
        return inputNum;
    }

    public Integer toInteger(String inputString){
        Integer inputNum;
        try {
               inputNum = Integer.parseInt(inputString);
           }catch (NumberFormatException e){
            throw new NumberFormatException("실패");
        }
        return inputNum;
    }
}
