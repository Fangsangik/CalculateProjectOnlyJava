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
                int a = sc.nextInt();

                System.out.print("두번쨰 숫자를 입력하세요 : ");
                int b = sc.nextInt();

                //버퍼 초기화
                sc.nextLine();

                System.out.print("기호를 입력하세요 (+, -, *, /) (프로그램 종료  : exit)\n : ");
                String op = sc.nextLine();

                if (op.equalsIgnoreCase("exit")) {
                    System.out.print("프로그램을 종료합니다.");
                    break;
                }

                int rst = 0;
                switch (op) {
                    case "+":
                        rst = calc.add(a, b);
                        break;

                    case "-":
                        rst = calc.subtract(a, b);
                        break;

                    case "*":
                        rst = calc.multiply(a, b);
                        break;

                    case "/":
                        rst = calc.divide(a, b);
                        break;

                    default:
                        System.out.print("잘못된 값을 입력하셨습니다 다시 시도해 주세요");
                        continue;
                }

                System.out.println("결과 : " + rst);
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
