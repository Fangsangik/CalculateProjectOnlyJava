package com.example.calculatorproject.level3;


//코드 중복이 많은데 해결 방벙?
//목적, 전치리, 후치리 -> 편하게 개발 할 수 있는 방향
//내부적으로 하나만 결정해서, 보여주는 값은 인티저로
//if 문으로 가냐, 파라미터로 가냐.

//operation Enum 타입에 정보를 관리, 사칙 연산 기능 수행
public enum Operation {

    ADD("+") {
        @Override
        public Double apply(double a, double b) {
            return a + b;
        }
    },

    SUBTRACT("-") {
        @Override
        public Double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public Double apply(double a, double b) {

            return a * b;

        }
    },

    DIVIDE("/") {
        @Override
        public Double apply(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract Double apply(double a, double b);
}