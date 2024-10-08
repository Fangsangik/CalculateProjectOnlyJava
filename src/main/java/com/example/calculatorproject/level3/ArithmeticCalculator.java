package com.example.calculatorproject.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Number -> int, double, long등 부모형 타입
public class ArithmeticCalculator <T extends Number & Comparable<T>> {

//제네릭이 Number type에 맞게 결과 값 가져오기
public class ArithmeticCalculator<T extends Number> {

    private final List<T> resultList = new ArrayList<>();

    public T calculate(T a, T b, Operation operatorType) {
        return operatorType.apply(a, b);
    }

    public List<Double> getBiggerRst(T val) {
        return rsts.stream()
                .filter(rsts -> Double.valueOf(val.doubleValue()).compareTo(rsts) < 0)
                .collect(Collectors.toList());
    }

    public List<Double> getRst() {
        return rsts;
    }
}
