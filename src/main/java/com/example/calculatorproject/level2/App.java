package com.example.calculatorproject.level2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();
                if (num1 < 0) {
                    System.out.println("양수로 입력해 주세요");
                    continue;
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();
                if (num2 < 0) {
                    System.out.println("양수로 입력해 주세요");
                    continue;
                }

                //버퍼정리 (next.int() 숫자를 읽고, next.line() 메서드 사용시
                //새로운 입력을 하기 전에 입력 버퍼에 남아있던 개행문자를 읽는 경우가 생김
                sc.nextLine();

                System.out.print("기호를 입력하세요 (+, -, *, /): ");
                String operator = sc.nextLine();

                //List에 값을 넣는다.
                List<Integer> result = new ArrayList<>();
                int calculateResult = calculate.calculate(num1, num2, operator);
                List<Integer> result = calculate.getResultList();
                result.add(calculateResult);
                calculate.setResultList(result);

                System.out.println("결과 : " + calculateResult);

            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("잘못입력하셨습니다 " + e.getMessage());
                continue;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.nextLine();
            if (remove.equalsIgnoreCase("remove")) {
                calculate.removeRst();
                System.out.println("저장된 데이터를 삭제했습니다.");
            }

            System.out.println("현재 저장된 결과 : " + calculate.getResults());
        }
        sc.close();
    }
}
