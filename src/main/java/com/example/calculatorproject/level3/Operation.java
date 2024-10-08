package com.example.calculatorproject.level3;


public enum Operation {
    ADD("+") {
        public double apply(double a, double b) {
            return a + b;
        }
    },

    SUBTRACT("-") {
        public double apply(double a, double b) {
            return a - b;
        }
    },

    MULTIPLY("*") {
        public double apply(double a, double b) {
            return a * b;
        }
    },

    DIVIDE("/") {
        public double apply(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };


    private String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract double apply(double a, double b);
}
