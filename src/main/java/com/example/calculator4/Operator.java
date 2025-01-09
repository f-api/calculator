package com.example.calculator4;

public enum Operator {
    ADD("+", new AddOperation()),
    SUBTRACT("-", new SubtractOperation()),
    MULTIPLY("*", new MultiplyOperation()),
    DIVIDE("/", new DivideOperation());

    private final String symbol;
    private final Operation operation;

    Operator(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public <T extends Number> T apply(T first, T second, Class<T> type) {
        return operation.apply(first, second, type);
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator operator : values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산 기호입니다. (+, -, *, / 중 하나여야 합니다)");
    }
}
