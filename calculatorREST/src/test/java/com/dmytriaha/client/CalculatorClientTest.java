package com.dmytriaha.client;

import com.dmytriaha.model.Calculation;
import com.dmytriaha.model.OperationType;
import org.junit.Test;

public class CalculatorClientTest {
    private CalculatorClient getClient() {
        return new CalculatorClient();
    }

    @Test
    public void testAdd() {
        Calculation res = getClient().add(1, 2, 3);
        check(OperationType.ADD, 6, res);
    }

    @Test
    public void testAdd1() {
        Calculation res = getClient().add(1, 2);
        check(OperationType.ADD, 3, res);
    }

    @Test
    public void testSubtract() {
        Calculation res = getClient().add(8, 2, 3);
        check(OperationType.SUBTRACT, 3, res);
    }

    @Test
    public void testSubtract1() {
        Calculation res = getClient().add(8, 2);
        check(OperationType.SUBTRACT, 6, res);
    }

    @Test
    public void testMultiply() {
        Calculation res = getClient().add(3, 2, 3);
        check(OperationType.MULTIPLY, 18, res);
    }

    @Test
    public void testMultiply1() {
        Calculation res = getClient().add(2, 3);
        check(OperationType.MULTIPLY, 6, res);
    }

    @Test
    public void testDivide() {
        Calculation res = getClient().add(18, 2, 3);
        check(OperationType.DIVIDE, 3, res);
    }

    @Test
    public void testDivide1() {
        Calculation res = getClient().add(11, 2);
        check(OperationType.DIVIDE, 5.5, res);
    }

    private boolean check(OperationType type, double res, Calculation calculation) {
        return calculation.getOperation() == type && calculation.getResult() == res;
    }
}