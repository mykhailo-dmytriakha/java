package com.onelogin.util;

import com.onelogin.math.Fraction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void toFraction() {
        Fraction fraction;
        fraction = Converter.toFraction("1_2/3");
        assertEquals(5, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());

        fraction = Converter.toFraction("11");
        assertEquals(11, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }
}
