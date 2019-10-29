package com.onelogin;

import com.onelogin.math.Fraction;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void add() {
        Fraction res = new Fraction(1, 2).add(new Fraction(2, 3));
        assertEquals("1_1/6", res.toString());
    }

    @Test
    public void subtract() {
        Fraction res = new Fraction(7, 6).subtract(new Fraction(2, 3));
        assertEquals("1/2", res.toString());
    }

    @Test
    public void multiply() {
        Fraction res = new Fraction(7, 6).multiply(new Fraction(2, 3));
        assertEquals("7/9", res.toString());
    }

    @Test
    public void divide() {
        Fraction res = new Fraction(7, 6).divide(new Fraction(2, 3));
        assertEquals("1_3/4", res.toString());
    }
}
