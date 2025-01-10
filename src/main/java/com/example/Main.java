package com.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimalValue = new BigDecimal("123456789.123456789123456789");
        double doubleFromBigDecimal = bigDecimalValue.doubleValue();

        // DecimalFormat으로 소수점 형식으로 출력
        DecimalFormat decimalFormat = new DecimalFormat("#.####################"); // 원하는 정밀도 설정

        System.out.println("BigDecimal to Double:");
        System.out.println("Original BigDecimal: " + decimalFormat.format(bigDecimalValue));
        System.out.println("Converted Double: " + decimalFormat.format(doubleFromBigDecimal));

        // 손실된 값을 명확히 보기 위해 BigDecimal과 Double의 차이 계산
        BigDecimal convertedBackToBigDecimal = new BigDecimal(doubleFromBigDecimal);
        BigDecimal difference = bigDecimalValue.subtract(convertedBackToBigDecimal);

        System.out.println("\nConverted Back to BigDecimal: " + decimalFormat.format(convertedBackToBigDecimal));
        System.out.println("Difference (Loss): " + decimalFormat.format(difference) + "\n");

        double value1 = 123.456789123456789; // 가장 가까운 근사 2진수 값
        BigDecimal bd1 = new BigDecimal(value1);
        System.out.println(bd1);

        String value2 = "123.456789123456789";
        BigDecimal bd2 = new BigDecimal(value2);
        System.out.println(bd2);

    }
}
