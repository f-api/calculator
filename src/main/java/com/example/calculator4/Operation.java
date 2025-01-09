package com.example.calculator4;

public interface Operation {

    <T extends Number> T apply(T firstNumber, T secondNumber, Class<T> type);
}
