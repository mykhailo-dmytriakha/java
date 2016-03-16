package _hackerrank.java.collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <p>task description https://www.hackerrank.com/challenges/java-hashset</p>
 */
public class JavaHashset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        Set<String> uniqPairs = new HashSet<>(testCases);
        while (testCases > 0) {
            String pair = in.nextLine();
            uniqPairs.add(pair);
            System.out.println(uniqPairs.size());
            testCases--;
        }
    }
}
