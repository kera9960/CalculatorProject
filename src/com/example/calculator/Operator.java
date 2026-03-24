package com.example.calculator;

enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE;

    public static Operator Convert(char symbol){
        switch (symbol){
            case '+':
                return PLUS;

            case '-':
                return MINUS;

            case '*':
                return MULTIPLY;

            case '/':
                return DIVIDE;

            default:
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
