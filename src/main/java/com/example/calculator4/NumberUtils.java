package com.example.calculator4;

import java.math.BigDecimal;

public class NumberUtils {

    public static <T extends Number> T castToType(BigDecimal bigDecimal, Class<T> type) {
        return switch (type.getSimpleName()) {
            case "BigDecimal" -> type.cast(bigDecimal);
            case "Integer" -> type.cast(bigDecimal.intValue());
            case "Double"  -> type.cast(bigDecimal.doubleValue());
            case "Long"    -> type.cast(bigDecimal.longValue());
            default -> throw new IllegalArgumentException("지원하지 않는 타입입니다: " + type.getSimpleName());
        };
    }

    public static BigDecimal convertToBigDecimal(Number number) {
        return new BigDecimal(number.toString());
    }
}
