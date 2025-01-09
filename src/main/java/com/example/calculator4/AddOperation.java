package com.example.calculator4;

import java.math.BigDecimal;

import static com.example.calculator4.NumberUtils.castToType;
import static com.example.calculator4.NumberUtils.convertToBigDecimal;

public class AddOperation implements Operation {
    @Override
    public <T extends Number> T apply(T a, T b, Class<T> type) {
        BigDecimal sum = convertToBigDecimal(a).add(convertToBigDecimal(b));
        return castToType(sum, type);
    }
}