package com.example.calculator2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator2 calculator = new Calculator2();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt();
            if (firstNumber < 0) {
                System.out.println("음수는 입력할 수 없습니다. 프로그램을 재시작합니다.");
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();
            if (secondNumber < 0) {
                System.out.println("음수는 입력할 수 없습니다. 프로그램을 재시작합니다.");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            double result = calculator.calculate(firstNumber, secondNumber, operator);

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if ("exit".equals(sc.next())) {
                break;
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (yes 입력 시 삭제)");
            if ("yes".equals(sc.next())) {
                calculator.removeResult();
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (yes 입력 시 조회)");
            if ("yes".equals(sc.next())) {
                List<Double> resultList = calculator.getResultList();
                System.out.println("저장된 연산결과는 : " + resultList.toString());
            }
        }
    }
}
