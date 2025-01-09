package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator2 {

    private final List<Double> resultList = new ArrayList<>();

    public double calculate(int firstNumber, int secondNumber, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두 번째 정수)가 0일 수 없습니다.");
                }
                result = (double) firstNumber / secondNumber;
                break;
            default:
                throw new IllegalArgumentException("사칙연산 기호는 +, -, *, / 중 하나여야 합니다.");
        }
        addResult(result);
        return result;
    }

    public List<Double> getResultList() {
        return resultList;
    }

    public void addResult(double result) {
        resultList.add(result);
    }

    public void removeResult() {
        resultList.remove(0);
    }
}
