package com.example.calculatorproject.level1_with_class;

//Calculate 클래슬 통헤 사칙 연산 기능 수행
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
    //간단한 역할만 수행 -> 상관 없음
    //(예외 처리 해주는 값이 동일하면 안에 처리)
    @Override
    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
