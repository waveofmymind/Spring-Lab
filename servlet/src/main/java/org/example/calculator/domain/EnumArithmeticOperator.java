package org.example.calculator.domain;

import java.util.Arrays;

public enum EnumArithmeticOperator {

    ADDITION("+") {
                @Override
                public int arithmeticCalculate(int operand1, int operand2) {
                    return operand1 + operand2;
                }
            },SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    EnumArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        EnumArithmeticOperator enumArithmeticOperator = Arrays.stream(values())
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산이 아닙니다."));
        return enumArithmeticOperator.arithmeticCalculate(operand1.toInt(),operand2.toInt());
    }

    protected abstract  int arithmeticCalculate(final int operand1,final int operand2);
}
