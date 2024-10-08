package com.example.calculatorproject.level1_with_class;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculate calc = new Calculate();

        while (true) {

            try {

                System.out.print("찻번째 숫자를 입력하세요 : ");
                int num1 = sc.nextInt();

                System.out.print("두번쨰 숫자를 입력하세요 : ");
                int num2 = sc.nextInt();

                //버퍼 초기화
                sc.nextLine();

                System.out.print("기호를 입력하세요 (+, -, *, /) (프로그램 종료  : exit)\n : ");

                String operation = sc.nextLine();

                if (operation.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;  // exit 입력 시 루프 종료
                }

                int result = 0;
                switch (operation) {
                    case "+":
                        result = calc.add(num1, num2);
                        break;

                    case "-":
                        result = calc.subtract(num1, num2);
                        break;

                    case "*":
                        result = calc.multiply(num1, num2);
                        break;

                    case "/":
                        rst = calc.divide(a, b);
                        break;

                    default:
                        System.out.print("잘못된 값을 입력하셨습니다 다시 시도해 주세요");
                        continue;
                }

                System.out.println("결과 : " + result);
            } catch (ArithmeticException e) {
                System.out.println("오류" + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("값을 잘못 입력했습니다. " + e.getMessage());
                sc.nextLine();
            }
        }

            sc.close();
        }
    }
