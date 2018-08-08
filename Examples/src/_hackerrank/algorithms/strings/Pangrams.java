package _hackerrank.algorithms.strings;

import java.util.Scanner;

public class Pangrams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(isPangram(line.toLowerCase().trim())){
            System.out.println("pangram");
        }else {
            System.out.println("not pangram");
        }
    }

    private static boolean isPangram(String line) {
//        return setOfChars.equals(allAlphabetChars);
    }
}
