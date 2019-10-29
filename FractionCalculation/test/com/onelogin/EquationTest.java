package com.onelogin;

import com.onelogin.math.Equation;
import org.junit.Test;

import static org.junit.Assert.*;

public class EquationTest {

    @Test
    public void solve() {
        Equation equation;
        equation = new Equation("2 * 2_1/2");
        assertEquals("5", equation.solve());

        equation = new Equation("1/2 * 3_3/4");
        assertEquals("1_7/8", equation.solve());

        equation = new Equation("2_3/8 + 9/8");
        assertEquals("3_1/2", equation.solve());
    }
}
