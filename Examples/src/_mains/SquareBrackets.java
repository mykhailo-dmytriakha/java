package _mains;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by Mykhailo on 8/8/2018.
 */
public class SquareBrackets {
    public static void main(String[] args) {
        Set<String> result = getCombinationsOfBrackets(4);
        result.forEach(System.out::println);
    }

    private static Set<String> getCombinationsOfBrackets(int i) {
        Set<String> result = new HashSet<>();
        if (i == 2) {
            result.add("[][]");
            result.add("[[]]");
            return result;
        }
        Set<String> variants = getCombinationsOfBrackets(i - 1);
        variants.forEach(variant -> {
            result.add("[]" + variant);
            result.add(variant + "[]");
            result.add("[" + variant + "]");
        });
        return result;
    }
}
