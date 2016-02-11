package _hackerrank.strings;

import java.util.Scanner;

/**
 * Created by mdmytiaha on 11-Feb-16.
 */
public class JavaStringsIntroduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstWord = sc.next();
        String secondWord = sc.next();

        System.out.println(firstWord.length() + secondWord.length());
        System.out.println(firstWord.compareTo(secondWord) > 0 ? "Yes" : "No");
        System.out.println((firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1)) + " " + (secondWord.substring(0, 1).toUpperCase() + secondWord.substring(1)));
    }
}
