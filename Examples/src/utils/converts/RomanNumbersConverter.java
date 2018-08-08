package utils.converts;

import utils.strings.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by Mykhailo on 8/3/2018.
 */
public class RomanNumbersConverter {
    public static final Map<Character, Integer> RomanNumbersMap = new HashMap<>(7);

    static {
        RomanNumbersMap.put('I', 1);
        RomanNumbersMap.put('V', 5);
        RomanNumbersMap.put('X', 10);
        RomanNumbersMap.put('L', 50);
        RomanNumbersMap.put('C', 100);
        RomanNumbersMap.put('D', 500);
        RomanNumbersMap.put('M', 1000);
    }

    public static int convertToArabic(String romanNumber) {
        validate(romanNumber);
        return calculate(romanNumber.toCharArray());
    }

    private static int calculate(char[] chars) {
        int sum = 0;
        sum += RomanNumbersMap.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char currentChar = chars[i];
            char previousChar = chars[i - 1];
            sum += RomanNumbersMap.get(currentChar);
            if (RomanNumbersMap.get(previousChar) < RomanNumbersMap.get(currentChar)) {
                sum -= RomanNumbersMap.get(previousChar) * 2;
            }
        }
        return sum;
    }

    public static void validate(String romanNumber) {
        validateCharacters(romanNumber);
        validateRules(romanNumber);
    }

    private static void validateRules(String romanNumber) {

    }

    private static void validateCharacters(String romanNumber) {
        if (StringUtil.isBlank(romanNumber)) {
            throw new IllegalArgumentException("empty string");
        }
        for (char c : romanNumber.toCharArray()) {
            Integer result = RomanNumbersMap.get(c);
            if (result == null) {
                throw new IllegalArgumentException("not valid number provided: " + romanNumber);
            }
        }
    }
}
