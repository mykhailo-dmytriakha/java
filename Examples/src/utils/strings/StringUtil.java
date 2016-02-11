package utils.strings;

import java.util.Arrays;

/**
 * Created by Михаил on 11.02.2016.
 */
public class StringUtil {
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1)
            return true;
        else if (str.length() == 2) {
            return str.charAt(0) == str.charAt(1);
        } else
            return str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome(str.substring(1, str.length() - 1));
    }

    public static boolean isAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String sortedStr1 = sortLettersInString(str1.toLowerCase());
        String sortedStr2 = sortLettersInString(str2.toLowerCase());
        return sortedStr1.equals(sortedStr2);
    }

    public static String sortLettersInString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
