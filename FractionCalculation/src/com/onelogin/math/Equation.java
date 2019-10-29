package com.onelogin.math;

import com.onelogin.util.EquationParser;

import java.util.List;

public class Equation {
    private final List<String> equation;
    private static final String operatorOrder = "/*+-";

    public Equation(String str) {
        equation = EquationParser.parse(str);
        if (equation == null) {
            throw new IllegalArgumentException("couldn't parse equation: " + str);
        }
    }

    public String solve() {
        String[] operators = operatorOrder.split("");
        for (int i = 0; i < operators.length; i++) {
            String operator = operators[i];
            int index = equation.indexOf(operator);
            if (index > 0) {
                solveExpression(index);
                i--;
            }
        }

        return equation.get(0);
    }

    private void solveExpression(int operatorIndex) {
        Expression expression = getExpression(operatorIndex);
        equation.set(operatorIndex, expression.calculate());
        equation.remove(operatorIndex + 1);
        equation.remove(operatorIndex - 1);
    }

    private Expression getExpression(int operatorIndex) {
        String a = equation.get(operatorIndex - 1);
        String b = equation.get(operatorIndex + 1);
        String operator = equation.get(operatorIndex);
        return new Expression(a, b, operator);
    }
}
