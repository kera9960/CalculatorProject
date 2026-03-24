package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArithmeticCalculator<Double> cal = new ArithmeticCalculator<Double>();                  // Calculator 클래스 객체 만들기

        Scanner sc = new Scanner(System.in);
        String output;

        do {
            Double firstNum;
            while (true){                                           // 검증 반복문
                System.out.print("첫 번째 숫자를 입력하세요: ");

                if (sc.hasNextDouble()){                               // 정수인지 검증 boolean
                    firstNum = sc.nextDouble();

                    if (firstNum >= 0 ){                            // 양수인지 검증
                        break;
                    } else {
                        System.out.println("양수를 입력하세요");
                    }
                } else {
                    System.out.println("숫자를 입력하세요");
                    sc.next();                                      // sc 입력 버퍼에 남은거 소비하는 기능
                }
            }

            Double secondNum;
            while (true){
                System.out.print("두 번째 숫자를 입력하세요: ");

                if (sc.hasNextDouble()){
                    secondNum = sc.nextDouble();

                    if (secondNum >= 0 ){
                        break;
                    } else {
                        System.out.println("양수를 입력하세요");
                    }
                } else {
                    System.out.println("숫자를 입력하세요");
                    sc.next();
                }
            }

            System.out.print("사칙연산 기호를 입력하세요 ( + , - , * , / ):  ");
            String operators = sc.next();
            char operator = operators.charAt(0);

            try {
                Operator symbol = Operator.Convert(operator);
                Double result = cal.calculate(firstNum,secondNum,symbol);
                System.out.println("결과: " +result );

            } catch (ArithmeticException e){
                System.out.println("0으로 나눌 수 없습니다.");
            } catch (IllegalArgumentException e){
                System.out.println("잘못된 연산자입니다.");
            }

            int resultCheck;
            do {
                System.out.println("---- 메뉴 ----");
                System.out.println("1. 결과 목록조회");
                System.out.println("2. 가장 오래된 데이터 삭제");
                System.out.println("3. 입력값보다 큰 결과 조회");
                System.out.println("4. 메뉴 종료");
                System.out.print("메뉴를 선택하세요: ");
                resultCheck = sc.nextInt();

                switch (resultCheck) {

                    case 1:
                        System.out.println(cal.getResultList());
                        break;

                    case 2:
                        try {
                            cal.removeResult();
                            System.out.println("데이터를 삭제했습니다.");
                            System.out.println(cal.getResultList());
                        } catch (IllegalStateException e) {
                            System.out.println("삭제할 데이터가 없습니다.");
                        }
                        break;

                    case 3:
                        System.out.print("값을 입력하세요: ");
                        Double inputNum = sc.nextDouble();
                        System.out.println(cal.greater(inputNum));
                        break;

                    case 4:
                        break;

                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력하세요");
                }
            } while (resultCheck != 4);

            System.out.print("종료하려면 exit를 입력하세요. 계속하려면 아무 값이나 입력하세요.: ");
            output = sc.next();

        } while (!output.equals("exit"));

        sc.close();
    }
}
