package _hackerrank.java.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by mdmytiaha on 11-Feb-16.
 */
public class JavaStringCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wholeWord = scanner.next();
        int k = scanner.nextInt();

        ArrayList<String> allSubStrings = new ArrayList<>();

        for(int i = 0; i <= wholeWord.length() - k; i++) {
            allSubStrings.add(wholeWord.substring(i, i + k));
        }
        Collections.sort(allSubStrings);
        System.out.println(allSubStrings.get(0));
        System.out.println(allSubStrings.get(allSubStrings.size() - 1));
    }
}
