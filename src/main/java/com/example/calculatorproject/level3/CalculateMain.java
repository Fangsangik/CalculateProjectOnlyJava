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
                    break;
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                String input2 = sc.nextLine();
                Number num2 = parseInput(input2);

                // 두 번째 숫자가 양수인지 확인
                if (num2.doubleValue() < 0) {
                    System.out.println("양수로 입력해 주세요");
                    break;
                }

                //버퍼정리 (next.int() 숫자를 읽고, next.line() 메서드 사용시
                //새로운 입력을 하기 전에 입력 버퍼에 남아있던 개행문자를 읽는 경우가 생김
                sc.nextLine();

                System.out.print("기호를 입력하세요 (+, -, *, /): ");
                String operator = sc.nextLine();

                Operation operation = getOperation(operator);

                double result = calculator.calculate(num1, num2, operation);
                System.out.println("결과 : " + result);

                // 계산 결과를 List에 추가
                resultList.add(result);

                List<Double> compareRst = calculator.getBiggerRst(compareVal);
                System.out.println("입력 값보다 큰 결과 : " + compareRst);


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
