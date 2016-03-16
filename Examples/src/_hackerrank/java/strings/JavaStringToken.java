package _hackerrank.java.strings;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Михаил on 12.02.2016.
 */
public class JavaStringToken {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(s, " !,?.\\_'@");
        System.out.println(tokenizer.countTokens());
        while (tokenizer.hasMoreElements()){
            System.out.println(tokenizer.nextElement());
        }
    }
}
