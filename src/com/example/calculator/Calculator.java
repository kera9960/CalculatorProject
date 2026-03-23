package com.example.calculator;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> resultList = new ArrayList<Integer>();

    public ArrayList<Integer> getResultList(){
        return resultList;
    }

    public void setResultList(ArrayList<Integer> resultList){
        this.resultList = resultList;
    }

    public void removeResult(){
        if (resultList.isEmpty()){
            throw new IllegalStateException("삭제할 데이터가 없습니다.");
        }
        resultList.remove(0);

    }


    public int calculate(int firstNum, int secondNum, char operator){
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
