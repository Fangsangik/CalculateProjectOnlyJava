package com.example.calculatorproject.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Number -> int, double, long등 부모형 타입

//제네릭이 Number type에 맞게 결과 값 가져오기
public class ArithmeticCalculator<T extends Number> {

    private final List<T> resultList = new ArrayList<>();

    public T calculate(T a, T b, Operation operatorType) {
        Double result = operatorType.apply(a.doubleValue(), b.doubleValue());
        return (T) result; //걀과를 원래 타입으로 변환
    }

    // List에서 입력된 값보다 큰 값을 필터링하는 메서드
    public List<T> getResultsGreaterThan(List<T> resultList, T compareVal) {
        List<T> filteredResults = new ArrayList<>();
        for (T result : resultList) {
            if (result.doubleValue() > compareVal.doubleValue()) { //doubleValue 비교
                // 소수점 이하가 없는 경우, 소수점 없이 출력
                filteredResults.add(result);
            }
        }
        return filteredResults;
    }

    public List<T> getResultList() {
        return resultList;
    }
}
