package com.example.calculatorproject.level1_with_class;

public class Calculate implements Operation {


    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {
       return num1 * num2;
    }

    //예외 처리를 여기서 하는게 좋을까? 아님 Main에서 처리하는게 좋을까?
    @Override
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }
}
