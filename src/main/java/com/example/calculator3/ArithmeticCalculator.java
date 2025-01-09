package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.calculator3.NumberUtils.castToType;

public class ArithmeticCalculator<T extends Number> {

    private final List<T> resultList = new ArrayList<>();
    private final Class<T> type;

    public ArithmeticCalculator(Class<T> type) {
        this.type = type;
    }

    public T calculate(T firstNumber, T secondNumber, Operator operator) {
        double num1 = firstNumber.doubleValue();
        double num2 = secondNumber.doubleValue();
        double result;

        switch (operator) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                if (num2 == 0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두 번째 숫자)가 0일 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("사칙연산 기호는 +, -, *, / 중 하나여야 합니다.");
        }

        T typedResult = castToType(result, type);
        addResult(typedResult);
        return typedResult;
    }

    public List<T> getResultsGreaterThan(T value) {
        return resultList.stream()
                .filter(r -> r.doubleValue() > value.doubleValue())
                .collect(Collectors.toList());
    }

    public void addResult(T result) {
        resultList.add(result);
    }
}
