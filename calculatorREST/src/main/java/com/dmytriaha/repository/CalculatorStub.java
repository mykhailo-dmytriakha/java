package com.dmytriaha.repository;

import com.dmytriaha.model.Calculation;
import com.dmytriaha.model.OperationType;

public class CalculatorStub implements Calculator {

    public Calculation add(Integer a, Integer b, Integer c) {

        int sum = a + b + c;
        Calculation result = new Calculation();
        result.setOperation(OperationType.ADD);
        result.setResult((double) sum);

        return result;
    }

    public Calculation add(Integer a, Integer b) {
        return add(a, b, 0);
    }

    public Calculation subtract(Integer a, Integer b, Integer c) {

        int subtract = a - b - c;
        Calculation result = new Calculation();
        result.setOperation(OperationType.SUBTRACT);
        result.setResult((double) subtract);

        return result;
    }

    public Calculation subtract(Integer a, Integer b) {
        return subtract(a, b, 0);
    }

    public Calculation multiply(Integer a, Integer b, Integer c) {

        int multiply = a * b * c;
        Calculation result = new Calculation();
        result.setOperation(OperationType.MULTIPLY);
        result.setResult((double) multiply);

        return result;
    }

    public Calculation multiply(Integer a, Integer b) {
        return multiply(a, b, 1);
    }

    public Calculation divide(Integer a, Integer b, Integer c) {

        double divide = (double) a / b / c;
        Calculation result = new Calculation();
        result.setOperation(OperationType.DIVIDE);
        result.setResult(divide);

        return result;
    }

    public Calculation divide(Integer a, Integer b) {
        return divide(a, b, 1);
    }
}
