package com.example.calculatorproject.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculateMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        // 결과를 저장할 List
        List<Double> resultList = new ArrayList<>();

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String input1 = sc.nextLine();
                double num1 = NumberSpecification.parseInput(input1);

                if (num1 < 0) {
                    System.out.println("양수로 입력해 주세요.");
                    continue;
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                String input2 = sc.nextLine();
                double num2 = NumberSpecification.parseInput(input2);

                if (num2 < 0) {
                    System.out.println("양수로 입력해 주세요.");
                    continue;
                }

                System.out.print("연산 기호를 입력하세요 (+, -, *, /): ");
                String operator = sc.nextLine();

                Operation operatorType = getOperatorType(operator);

                // 계산 수행 및 결과 출력
                Double result = calculator.calculate(num1, num2, operatorType);
                System.out.println("결과: " + NumberSpecification.formatNumber(result));

                // 계산 결과를 List에 추가
                resultList.add(result);

                // 특정 값보다 큰 결과 조회
                System.out.print("비교할 값을 입력하세요: ");
                Double compareVal = sc.nextDouble();
                sc.nextLine();  // 버퍼 정리

                // 비교한 값보다 큰 결과 필터링 및 출력
                List<Double> compareRst = calculator.getResultsGreaterThan(resultList, compareVal);
                if (compareRst.isEmpty()) {
                    System.out.println("입력 값보다 큰 결과가 없습니다.");
                } else {
                    System.out.print("입력 값보다 큰 결과: ");
                    for (Double doubleResult : compareRst) {
                        System.out.println(NumberSpecification.formatNumber(doubleResult)  + " ");
                    }
                }

                System.out.println();

                System.out.print("계속하시겠습니까? (exit 입력 시 종료): ");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        sc.close();
    }

    // 문자열로부터 OperatorType을 가져오는 메서드
    private static Operation getOperatorType(String symbol) {
        for (Operation op : Operation.values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다. (+, -, *, / 중 하나를 입력하세요.)");
    }
}
