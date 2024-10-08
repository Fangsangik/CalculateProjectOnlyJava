package com.example.calculatorproject.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    private List<Integer> result;

    public Calculate() {
        this.result = new ArrayList<>();
    }

    // 계산 메서드
    public int calculate(int a, int b, String op) {
        int rst = 0;  // 계산 결과를 저장할 변수

        switch (op) {
            case "+":
                rst = a + b;
                break;
            case "-":
                rst = a - b;
                break;
            case "*":
                rst = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                rst = a / b;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }

        result.add(rst);
        return rst;
    }

    // 리스트에서 첫 번째 결과 삭제
    public void removeRst() {
        if (!result.isEmpty()) {
            result.remove(0);
            System.out.println("첫 번째 결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }


    // 전체 결과 출력 (디버깅용)
    public List<Integer> getResults() {
        return result;
    }
}
