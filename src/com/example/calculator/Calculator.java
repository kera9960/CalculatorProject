package com.example.calculator;

import java.util.ArrayList;

public class Calculator {

    ArrayList<Integer> resultList = new ArrayList<Integer>();

    int calculate(int firstNum, int secondNum, char operator){
            int result;

            switch (operator){

                case '+': result = firstNum + secondNum;
                break;

                case '-': result = firstNum - secondNum;
                break;

                case '*': result = firstNum * secondNum;
                break;

                case '/': if (secondNum==0){
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                } else {
                    result = firstNum / secondNum;
                    break;
                }
                default:
                    throw new IllegalArgumentException("지원하지 않는 연산자입니다");
            }

            resultList.add(result);

            return result;
    }

}
