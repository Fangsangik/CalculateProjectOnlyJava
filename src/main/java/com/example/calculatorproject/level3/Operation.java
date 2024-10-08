package com.example.calculatorproject.level3;


//코드 중복이 많은데 해결 방벙?
public enum Operation {
    ADD("+") {
        @Override
        public <T extends Number> T apply(T a, T b) {
            if (a instanceof Double || b instanceof Double) {
                return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
            } else if (a instanceof Integer || b instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() + b.intValue());
            } else if (a instanceof Long || b instanceof Long) {
                return (T) Long.valueOf(a.longValue() + b.longValue());
            } else if (a instanceof Float || b instanceof Float) {
                return (T) Float.valueOf(a.floatValue() + b.floatValue());
            } else {
                throw new IllegalArgumentException("지원되지 않는 타입입니다.");
            }
        }
    },

    SUBTRACT("-") {
        @Override
        public <T extends Number> T apply(T a, T b) {
            if (a instanceof Double || b instanceof Double) {
                return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
            } else if (a instanceof Integer || b instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() - b.intValue());
            } else if (a instanceof Long || b instanceof Long) {
                return (T) Long.valueOf(a.longValue() - b.longValue());
            } else if (a instanceof Float || b instanceof Float) {
                return (T) Float.valueOf(a.floatValue() - b.floatValue());
            } else {
                throw new IllegalArgumentException("지원되지 않는 타입입니다.");
            }
        }
    },
    MULTIPLY("*") {
        @Override
        public <T extends Number> T apply(T a, T b) {
            if (a instanceof Double || b instanceof Double) {
                return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
            } else if (a instanceof Integer || b instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() * b.intValue());
            } else if (a instanceof Long || b instanceof Long) {
                return (T) Long.valueOf(a.longValue() * b.longValue());
            } else if (a instanceof Float || b instanceof Float) {
                return (T) Float.valueOf(a.floatValue() * b.floatValue());
            } else {
                throw new IllegalArgumentException("지원되지 않는 타입입니다.");
            }
        }
    },
    DIVIDE("/") {
        @Override
        public <T extends Number> T apply(T a, T b) {
            if (b.doubleValue() == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }

            if (a instanceof Double || b instanceof Double) {
                return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
            } else if (a instanceof Integer || b instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() / b.intValue());
            } else if (a instanceof Long || b instanceof Long) {
                return (T) Long.valueOf(a.longValue() / b.longValue());
            } else if ( a instanceof Float || b instanceof Float) {
                return (T) Float.valueOf(a.floatValue() / b.floatValue());
            } else {
                throw new IllegalArgumentException("지원되지 않는 타입입니다.");
            }
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract <T extends Number> T apply(T a, T b);
}