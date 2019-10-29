package com.onelogin;

import com.onelogin.math.Expression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {

    @Test
    public void calculate() {
        Expression expression;
        expression = new Expression("2", "5", "*");
        assertEquals("10", expression.calculate());

        expression = new Expression("10", "5", "/");
        assertEquals("2", expression.calculate());

        expression = new Expression("2", "5", "+");
        assertEquals("7", expression.calculate());

        expression = new Expression("5", "2", "-");
        assertEquals("3", expression.calculate());
    }
}
