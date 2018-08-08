package _mains;

import utils.converts.RomanNumbersConverter;

/**
 * @author by Mykhailo on 8/3/2018.
 */
public class RomanNumbers {
    public static void main(String[] args) {
        String input = "LXXIXIV";
        int result = RomanNumbersConverter.convertToArabic(input);
        System.out.println(result);
    }
}
