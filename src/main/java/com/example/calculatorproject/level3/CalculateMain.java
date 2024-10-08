package com.example.calculatorproject.level3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculateMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

        // 결과를 저장할 List
        List<Number> resultList = new ArrayList<>();

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String input1 = sc.nextLine();  // 문자열로 입력을 받음
                Number num1 = parseInput(input1);  // 입력을 분석하여 적절한 타입으로 변환

                // 첫 번째 숫자가 양수인지 확인
                if (num1.doubleValue() < 0) {
                    System.out.println("양수로 입력해 주세요");
                    continue;  // 양수가 아닐 경우 다시 입력받음
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                String input2 = sc.nextLine();
                Number num2 = parseInput(input2);

                // 두 번째 숫자가 양수인지 확인
                if (num2.doubleValue() < 0) {
                    System.out.println("양수로 입력해 주세요");
                    continue;  // 양수가 아닐 경우 다시 입력받음
                }

                //버퍼정리 (next.int() 숫자를 읽고, next.line() 메서드 사용시
                //새로운 입력을 하기 전에 입력 버퍼에 남아있던 개행문자를 읽는 경우가 생김
                sc.nextLine();

                System.out.print("기호를 입력하세요 (+, -, *, /): ");
                String operator = sc.nextLine();

                Operation operation = getOperation(operator);

                // 계산 수행 및 결과 출력
                Number result = calculator.calculate(num1, num2, operatorType);
                System.out.println("결과: " + result);

                // 계산 결과를 List에 추가
                resultList.add(result);

                // 특정 값보다 큰 결과 조회
                System.out.print("비교할 값을 입력하세요: ");
                Number compareVal = sc.nextDouble();
                sc.nextLine();  // 버퍼 정리

                // 비교한 값보다 큰 결과 필터링 및 출력
                List<Number> compareRst = calculator.getResultsGreaterThan(resultList, compareVal);
                System.out.println("입력 값보다 큰 결과: " + compareRst);


                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("잘못입력하셨습니다. 숫자를 입력해 주세요");
                sc.nextLine();
                continue;
            }

        }
        sc.close();
    }

    // 입력값을 분석하여 적절한 Number 타입으로 변환하는 메서드
    private static Number parseInput(String input) {
        if (input.contains(".")) {
            return Double.parseDouble(input);
        } else {
            return Integer.parseInt(input);
        }
    }

    // 문자열로부터 OperatorType을 가져오는 메서드
    private static Operation getOperatorType(String symbol) {
        for (Operation op : Operation.values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }
}
