package com.onelogin;

import com.onelogin.math.Equation;

public class Solution {
    public static void main(String[] args) {
        String fractionEquation = "7/8 + 3 / 3 / 3 * 3 * 3 / 3";
        String result = calculate(fractionEquation);
        System.out.println(fractionEquation + " = " + result);
    }

    public static String calculate(String str) {
        Equation equation = new Equation(str);
        return equation.solve();
    }
}
