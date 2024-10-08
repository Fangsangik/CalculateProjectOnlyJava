package com.example.calculatorproject.level1;


import java.util.Scanner;

public class CalculateMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //내부에 종료 조건 X -> 무한루프
        //문자열변수 -> exist 조건에 맞으면 (true) 수정해보기
        String op = sc.nextLine();
        while (!op.equals("exit")) {

            System.out.print("첫 숫자를 입력하세요 : ");
            int num1 = sc.nextInt();

            if (num1 < 0) {
                System.out.println("양의 정수만 입력이 가능합니다. 다시 입력하세요");
                sc.nextLine();
                continue;
            }

            System.out.print("두번쨰 숫자를 입력하세요 : ");
            int num2 = sc.nextInt();
            if (num2 < 0) {
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

            int result = 0;

            if (op.equals("+")) {
                result = num1 + num2;
            } else if (op.equals("-")) {
                result = num1 - num2;
            } else if (op.equals("*")) {
                result = num1 * num2;
            } else if (op.equals("/")) {
                if (num2 ==  0) {
                    System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요");
                    continue;
                }
                result = num1 / num2;
            } else {
                System.out.print("잘못된 연산자 입니다.");
                continue;

            }
            System.out.println("rst = " + result);
        }
        sc.close();
    }
}


