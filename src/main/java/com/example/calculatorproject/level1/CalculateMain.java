package com.example.calculatorproject.level1;


import java.util.Scanner;

//클레스 없이 기본적인 연산 수행할 수 있는 계산기 만들기
public class CalculateMain {
    public static void main(String[] args) {
        //Scanner 적용
        Scanner sc = new Scanner(System.in);


        while (true) {

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

            //사칙연산 기호를 입력받기
            char op = sc.next().charAt(0);

            //종료시 exit
            String input = String.valueOf(op);
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;  // exit 입력 시 루프 종료
            }

            int result = 0;

            // 사칙연산 기호 사용해서 연산 진행 & 결과 입력
            if (op == '+') {
                result = num1 + num2;
            } else if (op == '-') {
                result = num1 - num2;
            } else if (op == '*') {
                result = num1 * num2;
            } else if (op == '/') {
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


