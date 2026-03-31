package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {      // 숫자 타입만 받기

    private List<Double> resultList = new ArrayList<Double>();

    public List<Double> getResultList(){
        List<Double> copyList = new ArrayList<>();
        copyList.addAll(resultList);
        return copyList;
//        return Collections.unmodifiableList(resultList)   읽기 전용으로 만드는 Collections.unmodifiableList() 를 이용하는 것도 고려 가능(수정이 안됨)
    }

    public void removeResult(){
        if (resultList.isEmpty()){
            throw new IllegalStateException("삭제할 데이터가 없습니다.");
        }
        resultList.remove(0);
    }

    public List<Double> higher(Double inputNum){
        List<Double> high = resultList.stream()
            .filter(num -> num > inputNum)
            .collect(Collectors.toList());
            return high;
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
