package _hackerrank.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Михаил on 13.02.2016.
 */
public class JavaRegex2DuplicateWords {
    public static void main(String[] args) {
        String pattern = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
        Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String input = in.nextLine();
            Matcher m = r.matcher(input);
            boolean findMatch = true;
            while (m.find()) {
                String duplicatedWords = m.group();
                input = input.replaceAll(duplicatedWords, m.group(1));
                findMatch = false;
            }
            System.out.println(input);
            testCases--;
        }
    }
}
