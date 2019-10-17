package _leetCode.strings;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidAnagram {
    public static void main(String[] args) {
        isAnagram("fe", "ja");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        String s1 = Stream.of(s.split("")).sorted().collect(Collectors.joining());
        String s2 = Stream.of(t.split("")).sorted().collect(Collectors.joining());

        return s1.equals(s2);
    }
}
