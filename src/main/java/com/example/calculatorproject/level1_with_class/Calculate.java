package com.example.calculatorproject.level1_with_class;

public class Calculate implements Operation {


    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
       return a * b;
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
