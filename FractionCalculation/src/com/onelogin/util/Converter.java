package com.onelogin.util;

import com.onelogin.math.Fraction;

public class Converter {
    private Converter() {}

    public static Fraction toFraction(String str) {
        String[] s = str.split("_");
        int wholeNum = 0;
        int afterUnderscore = 0;
        if (s.length > 1) {
            wholeNum = Integer.parseInt(s[0]);
            afterUnderscore++;
        }
        Fraction fraction;
        String[] fractionParts = s[afterUnderscore].split("/");
        int numerator;
        int denominator = 1;
        if (fractionParts.length > 1) {
            numerator = Integer.parseInt(fractionParts[0]);
            denominator = Integer.parseInt(fractionParts[1]);
        } else {
            numerator = Integer.parseInt(fractionParts[0]);
        }
        fraction = new Fraction(numerator + wholeNum * denominator, denominator);
        return fraction;
    }
}
