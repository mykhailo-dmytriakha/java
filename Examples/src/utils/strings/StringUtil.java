package utils.strings;

/**
 * Created by Михаил on 11.02.2016.
 */
public class StringUtil {
    public static Boolean isPalindrome(String str) {
        if (str.length() <= 1)
            return true;
        else if (str.length() == 2) {
            return str.charAt(0) == str.charAt(1);
        } else if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        } else {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
    }
}
