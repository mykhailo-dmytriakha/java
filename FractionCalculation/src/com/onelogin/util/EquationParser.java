package com.onelogin.util;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

public class EquationParser {
    private EquationParser() {}

    public static List<String> parse(String string) {
        List<String> result = new ArrayList<>();
        for (String s : string.split(" ")) {
            if (isValid(s)) {
                result.add(s);
            } else {
                return null;
            }
        }

        // couldn't start or ends with math operator
        String start = result.get(0);
        String end = result.get(result.size() - 1);
        if (isOperator(start) || isOperator(end)) {
            // couldn't start or ends with math operator
            return null;
        }

        // couldn't be two numbers or two operators next to each other
        boolean prevFlag = false;
        for (String s : result) {
            boolean flag = isOperator(s);
            if (prevFlag == flag) {
                prevFlag = !flag;
            } else {
                return null;
            }
        }
        return result;
    }

    private static boolean isOperator(String s) {
        return !isDigit(s.charAt(0));
    }

    public static boolean isValid(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            // empty strings
            return false;
        }
        if (chars.length == 1) {
            if (chars[0] == '_') {
                // couldn't be standalone '_'
                return false;
            }
        } else {
            //Length >1
            // couldn't start or ends with math operator and '_'
            if (isAllowed(chars[0]) || isAllowed(chars[chars.length - 1])) {
                return false;
            }
        }

        int slashCounter = 0;
        int underscoreCounter = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];

            if (aChar == '_') {
                if (slashCounter > 0) {
                    // '_' could be only before '/'
                    return false;
                }
                underscoreCounter++;
            }
            if (aChar == '/') {
                slashCounter++;
            }
            if (slashCounter >= 2 || underscoreCounter >= 2) {
                //'_' and "/" should be appears only once
                return false;
            }

            boolean isDigit = isDigit(aChar);
            boolean isAllowed = isAllowed(aChar);

            if (!isDigit && !isAllowed) {
                // not allowed character (ex: 'a', '(' or any other)
                return false;
            }
            if ((aChar == '_') || (aChar == '/' && chars.length > 1)) {
                //'_' and "/" should be inside numbers
                if (i == 0 || i == chars.length - 1) {
                    return false;
                }
                if (!isDigit(chars[i - 1]) || !isDigit(chars[i + 1])) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isAllowed(char aChar) {
        return isMathOperator(aChar) || aChar == '_';
    }

    private static boolean isMathOperator(char aChar) {
        return aChar == '+' || aChar == '-' || aChar == '*' || aChar == '/';
    }
}

