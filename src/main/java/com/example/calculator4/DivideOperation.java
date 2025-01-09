package com.example.calculator4;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.example.calculator4.NumberUtils.castToType;
import static com.example.calculator4.NumberUtils.convertToBigDecimal;

public class DivideOperation implements Operation {
    @Override
    public <T extends Number> T apply(T a, T b, Class<T> type) {
        BigDecimal divisor = convertToBigDecimal(b);
        if (BigDecimal.ZERO.compareTo(divisor) == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두 번째 숫자)가 0일 수 없습니다.");
        }
        BigDecimal div = convertToBigDecimal(a).divide(divisor, RoundingMode.HALF_UP);
        return castToType(div, type);
    }
}
