package com.example.calculatorproject.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Number -> int, double, long등 부모형 타입

//제네릭이 Number type에 맞게 결과 값 가져오기
public class ArithmeticCalculator<T extends Double> {

    private final List<Double> resultList = new ArrayList<>();

    public Double calculate(double a, double b, Operation operatorType) {
        return operatorType.apply(a, b);
    }

    // List에서 입력된 값보다 큰 값을 필터링하는 메서드
    public List<Double> getResultsGreaterThan(List<Double> resultList, Double compareVal) {
        List<Double> filteredResults = new ArrayList<>();
        for (Double result : resultList) {
            if (result > compareVal) {
                // 소수점 이하가 없는 경우, 소수점 없이 출력
                filteredResults.add(result);
            }
        }
        return filteredResults;
    }

    public List<Double> getResultList() {
        return resultList;
    }
}
