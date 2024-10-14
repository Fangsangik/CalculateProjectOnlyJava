package com.example.calculatorproject.level3;

public class NumberSpecification {
    public static Double parseInput(String input) {
        try {
            // 소수점이 있는지 여부로 정수와 실수를 구분
            if (input.contains(".")) {
                return Double.parseDouble(input);  // 소수점이 있으면 실수로 반환
            } else {
                return Double.valueOf(Integer.parseInt(input));  // 소수점이 없으면 정수로 처리한 후 Double로 반환
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다. 다시 입력해주세요.");
        }
    }

    public static String formatNumber(Double number) {
        if (number % 1 == 0) {
            return String.valueOf(number.intValue());  // 정수로 변환
        } else {
            return String.valueOf(number);  // 실수는 그대로 반환
        }
    }
}
