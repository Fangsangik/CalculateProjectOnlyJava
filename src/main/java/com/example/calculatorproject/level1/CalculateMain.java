package com.example.calculatorproject.level1;

import ch.qos.logback.classic.spi.IThrowableProxy;

import java.util.Scanner;

public class CalculateMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("첫 숫자를 입력하세요 : ");
            int a = sc.nextInt();
            if (a < 0) {
                System.out.println("양의 정수만 입력이 가능합니다. 다시 입력하세요");
                sc.nextLine();
                continue;
            }

            System.out.print("두번쨰 숫자를 입력하세요 : ");
            int b = sc.nextInt();
            if (b < 0) {
                System.out.println("양의 정수만 입력이 가능합니다. 다시 입력하세요");
                sc.nextLine();
                continue;
            }

            sc.nextLine();

            System.out.print("+, -, *, / 중 히나를 입력해주세요 (종료 = exit) : ");
            String op = sc.nextLine();

            if (op.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다. ");
                break;
            }

            int rst = 0;

            if (op.equals("+")) {
                rst = a + b;
            } else if (op.equals("-")) {
                rst = a - b;
            } else if (op.equals("*")) {
                rst = a * b;
            } else if (op.equals("/")) {
                if (b == 0) {
                    System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요");
                    continue;
                }
                rst = a / b;
            } else {
                System.out.print("잘못된 연산자 입니다.");
                continue;

            }
            System.out.println("rst = " + rst);
        }
        sc.close();
    }
}


