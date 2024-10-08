package com.example.calculatorproject.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    private List<Integer> resultList;

    public Calculate() {
        this.resultList = new ArrayList<>();
    }

    // 계산 메서드
    public int calculate(int a, int b, String op) {
        //줄여쓸때와 안줄여쓸때 조직마다 다르긴 하지만, 조직이 크면 -> 조직 규칙
        //줄여쓰기 연습 X
        int result = 0;  // 계산 결과를 저장할 변수

        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }

        //result에 add를 하는 행위는 계산 기능과 관계 없음
        return result;
    }

    // 리스트에서 첫 번째 결과 삭제
    public void removeRst() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
            System.out.println("첫 번째 결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }


    // 전체 결과 출력 (디버깅용)
    public String getResults() {
        return resultList.toString();
    }
}
