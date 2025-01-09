package com.example.calculator3;

public class NumberUtils {

    public static <T extends Number> T castToType(double result, Class<T> type) {
        return switch (type.getSimpleName()) {
            case "Integer" -> type.cast((int) result);
            case "Double" -> type.cast(result);
            case "Long" -> type.cast((long) result);
            default -> throw new IllegalArgumentException("지원하지 않는 타입입니다.");
        };
    }
}
