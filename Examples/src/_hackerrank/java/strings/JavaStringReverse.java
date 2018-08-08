package _hackerrank.java.strings;

import java.util.Scanner;
import static utils.strings.StringUtil.isPalindrome;

/**
 * Created by Михаил on 11.02.2016.
 */
public class JavaStringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(isPalindrome(word) ? "Yes" : "No");
    }
}
