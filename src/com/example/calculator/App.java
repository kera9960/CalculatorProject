package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        String output;

        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNum = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNum = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하세요 ( + , - , * , / ):  ");
            String operators = sc.next();
            char operator = operators.charAt(0);

            switch (operator){

                case '+' : int plusNum = firstNum + secondNum;
                    System.out.println("결과: " + plusNum);
                    break;

                case '-' : int minusNum = firstNum - secondNum;
                    System.out.println("결과: " + minusNum);
                    break;

                case '*' : int multiplyNum = firstNum * secondNum;
                    System.out.println("결과: " + multiplyNum);
                    break;

                case '/' : int divideNum = firstNum / secondNum;
                    System.out.println("결과: " + divideNum);
                    break;

                default:
                    System.out.println("잘못된 연산자입니다");

            }

            System.out.print("종료하려면 exit를 입력하세요. 계속하려면 아무 값이나 입력하세요.: ");
            output = sc.next();

        } while (!output.equals("exit"));
    }
}
