package com.example.calculatorproject.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Number -> int, double, long등 부모형 타입
public class ArithmeticCalculator <T extends Number> {

    private final List<Double> rsts = new ArrayList<>();

    public double calculate(T a, T b, Operation operation) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();
        double result = operation.apply(num1, num2);
        rsts.add(result);

        return result;
    }

    public List<Double> getBiggerRst(double val) {
        return rsts.stream()
                .filter(rsts -> rsts > val)
                .collect(Collectors.toList());
    }

    public List<Double> getRst() {
        return rsts;
    }
}
