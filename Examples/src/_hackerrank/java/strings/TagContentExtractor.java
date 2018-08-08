package _hackerrank.java.strings;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mdmytiaha on 15-Feb-16.
 * not solved
 * @link https://www.hackerrank.com/challenges/tag-content-extractor
 */
public class TagContentExtractor {
    private static final String NONE = "None";
    public static final String REGEX = "<(.+)>(.+)<(?:\\/\\1)>";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();
            handleLine(line);
            testCases--;
        }
    }

    public static void handleLine(String str) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> lines = new ArrayList<>();
        while (matcher.find()) {
            lines.add(matcher.group());
        }
        if (lines.size() > 0) {
            for (String line : lines) {
                proceedContent(line);
            }
        } else {
            println(NONE);
        }
    }


    public static void proceedContent(String str) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        String content = matcher.group(2);

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(content);
        ArrayList<String> lines = new ArrayList<>();
        while (m.find()) {
            lines.add(m.group());
        }
        if (lines.size() > 0) {
            for (String line : lines) {
                proceedContent(line);
            }
        } else {
            if (hasTags(content)) {
                println(NONE);
            } else {
                println(content);
            }
        }
    }

    private static boolean hasTags(String str) {

        Pattern pattern = Pattern.compile("<(.+)>(.*)<\\/(.+)>");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private static void println(String content) {
        System.out.println(content);
    }
}
