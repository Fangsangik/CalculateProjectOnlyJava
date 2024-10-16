package com.example.calculatorproject.level2;

import java.util.ArrayList;
import java.util.List;

//Calculate 클래스 적용
public class Calculate {

    //연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 접근 X
    private List<Integer> resultList;

    public Calculate() {
        this.resultList = new ArrayList<>();
    }

    // 계산 메서드
    public int calculate(int a, int b, String op) {

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
