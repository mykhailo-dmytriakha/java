package _hackerrank.strings;

import java.util.Scanner;

import static utils.strings.StringUtil.isAnagrams;

/**
 * Created by Михаил on 11.02.2016.
 */
public class JavaAnagrams {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        boolean ret = isAnagrams(A, B);
        if (ret) System.out.println("Anagrams");
        else System.out.println("Not Anagrams");
    }
}
