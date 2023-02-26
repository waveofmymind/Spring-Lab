package org.example.calculator.tobe;


import org.example.calculator.domain.PositiveNumber;

public interface NewArithmeticOperator {

    boolean supports(String operator);

    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
