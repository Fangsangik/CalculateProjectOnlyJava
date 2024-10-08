package com.example.calculatorproject.level3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculateMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextDouble();
                if (num1 < 0) {
                    System.out.println("양수로 입력해 주세요");
                    break;
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();
                if (num2 < 0) {
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

                //비교값 안담아짐
                //filter 사용시 변수 값 잘못대입
                System.out.println("비교할 값을 비교하세요 : ");
                double compareVal = sc.nextDouble();
                sc.nextLine();

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

    //람다는 아직 어렵....
    //입략 문자열 연산자 -> enum 변환
    private static Operation getOperation(String operation) {
        //스트림 생성 시작 알림
        return Arrays.stream(Operation.values())
                //operation과 일치하는 값 찾기
                .filter(x -> x.getSymbol().equals(operation))
                //찾은 값 중 첫번째 값 사용
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 값입니다."));
    }
}
