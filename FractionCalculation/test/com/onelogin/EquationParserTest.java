package com.onelogin;

import com.onelogin.util.EquationParser;
import org.junit.Assert;
import org.junit.Test;

public class EquationParserTest {
    @Test
    public void isValid() {
        Assert.assertTrue(EquationParser.isValid("+"));
        Assert.assertTrue(EquationParser.isValid("-"));
        Assert.assertTrue(EquationParser.isValid("*"));
        Assert.assertTrue(EquationParser.isValid("/"));
        Assert.assertTrue(EquationParser.isValid("34"));
        Assert.assertTrue(EquationParser.isValid("3/4"));
        Assert.assertTrue(EquationParser.isValid("1_3/4"));
    }

    @Test
    public void isNotValid() {
        Assert.assertFalse(EquationParser.isValid(""));
        Assert.assertFalse(EquationParser.isValid("+4"));
        Assert.assertFalse(EquationParser.isValid("4-"));
        Assert.assertFalse(EquationParser.isValid("4_"));
        Assert.assertFalse(EquationParser.isValid("a"));
        Assert.assertFalse(EquationParser.isValid("4a"));
        Assert.assertFalse(EquationParser.isValid("3/"));
        Assert.assertFalse(EquationParser.isValid("_3/4"));
        Assert.assertFalse(EquationParser.isValid("3/4_"));
        Assert.assertFalse(EquationParser.isValid("1__3/4"));
        Assert.assertFalse(EquationParser.isValid("1_3//4"));
        Assert.assertFalse(EquationParser.isValid("1/3/4"));
        Assert.assertFalse(EquationParser.isValid("1_3_4"));
        Assert.assertFalse(EquationParser.isValid("2_1/3_4"));
        Assert.assertFalse(EquationParser.isValid("1/3_4"));
    }

    @Test
    public void parsable() {
        Assert.assertNotNull(EquationParser.parse("3 + 1/2 * 3_3/4"));
    }

    @Test
    public void notParsable() {
        Assert.assertNull(EquationParser.parse(""));
        Assert.assertNull(EquationParser.parse("3 + 1/2 * 3/3/4"));
        Assert.assertNull(EquationParser.parse("+3 + 1/2 * 3/4"));
        Assert.assertNull(EquationParser.parse("+3 + 1/2 * 3/4-"));
        Assert.assertNull(EquationParser.parse("+ 3 + 1/2 * 3/4"));
        Assert.assertNull(EquationParser.parse("3 + 1/2 * 3/4 -"));
        Assert.assertNull(EquationParser.parse("3 + + 1/2 * 3/4"));
        Assert.assertNull(EquationParser.parse("3 3 + 1/2 * 3/4"));
    }
}
