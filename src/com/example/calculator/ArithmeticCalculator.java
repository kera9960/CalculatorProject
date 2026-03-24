package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {      // 숫자 타입만 받기

    private ArrayList<Double> resultList = new ArrayList<Double>();

    public ArrayList<Double> getResultList(){
        return resultList;
    }

    public void removeResult(){
        if (resultList.isEmpty()){
            throw new IllegalStateException("삭제할 데이터가 없습니다.");
        }
        resultList.remove(0);
    }

    public List<Double> greater(Double inputNum){
        List<Double> big = resultList.stream()
            .filter(num -> num > inputNum)
            .collect(Collectors.toList());
            return big;
    }

    public Double calculate(T firstNum, T secondNum,Operator symbol){
            Double result;

            switch (symbol){

                case PLUS: result = firstNum.doubleValue() + secondNum.doubleValue();
                break;

                case MINUS: result = firstNum.doubleValue() - secondNum.doubleValue();
                break;

                case MULTIPLY: result = firstNum.doubleValue() * secondNum.doubleValue();
                break;

                case DIVIDE: if (secondNum.doubleValue()==0){
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                } else {
                    result = firstNum.doubleValue() / secondNum.doubleValue();
                    break;
                }
                default:
                    throw new IllegalArgumentException("지원하지 않는 연산자입니다");
            }

            resultList.add(result);

            return result;
    }

}
