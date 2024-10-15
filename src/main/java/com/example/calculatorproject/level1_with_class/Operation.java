package com.example.calculatorproject.level1_with_class;

//인터페이스를 사용해 단순 기능적 부분만 할 수 있도록
public interface Operation {
    int add(int num1, int num2);
    int subtract(int num1, int num2);
    int multiply(int num1, int num2);
    int divide(int num1, int num2);
}
