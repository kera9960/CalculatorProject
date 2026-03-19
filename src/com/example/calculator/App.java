package com.example.calculator;

import java.util.Scanner;

public class App {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String output;

        do {
            int firstNum;
            while (true){                                           // 검증 반복문
                System.out.print("첫 번째 숫자를 입력하세요: ");

                if (sc.hasNextInt()){                               // 정수인지 검증 boolean
                    firstNum = sc.nextInt();

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

            int secondNum;

            while (true){
                System.out.print("두 번째 숫자를 입력하세요: ");

                if (sc.hasNextInt()){
                    secondNum = sc.nextInt();

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

            System.out.println("사칙연산 기호를 입력하세요 ( + , - , * , / ):  ");
            String operators = sc.next();
            char operator = operators.charAt(0);

            switch (operator){

                case '+' :
                    int plusNum = firstNum + secondNum;
                    System.out.println("결과: " + plusNum);
                    break;

                case '-' :
                    int minusNum = firstNum - secondNum;
                    System.out.println("결과: " + minusNum);
                    break;

                case '*' :
                    int multiplyNum = firstNum * secondNum;
                    System.out.println("결과: " + multiplyNum);
                    break;

                case '/' :
                    if (secondNum == 0){
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    int divideNum = firstNum / secondNum;
                    System.out.println("결과: " + divideNum);
                }
                break;

                default:
                    System.out.println("잘못된 연산자입니다");

            }

            System.out.print("종료하려면 exit를 입력하세요. 계속하려면 아무 값이나 입력하세요.: ");
            output = sc.next();

        } while (!output.equals("exit"));
    }
}
