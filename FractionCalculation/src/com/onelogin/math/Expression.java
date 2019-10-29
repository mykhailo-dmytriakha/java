package com.onelogin.math;

import static com.onelogin.util.Converter.toFraction;

public class Expression {
    private Fraction a;
    private Fraction b;
    private String operator;

    public Expression(String a, String b, String operator) {
        this.a = toFraction(a);
        this.b = toFraction(b);
        this.operator = operator;
    }

    public String calculate() {
        switch (operator) {
            case "*":
                return a.multiply(b).toString();
            case "/":
                return a.divide(b).toString();
            case "+":
                return a.add(b).toString();
            case "-":
                return a.subtract(b).toString();
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }
}
