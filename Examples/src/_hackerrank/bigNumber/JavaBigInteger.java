package _hackerrank.bigNumber;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Михаил on 18.02.2016.
 */
public class JavaBigInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = new BigInteger(scanner.nextLine());
        BigInteger b = new BigInteger(scanner.nextLine());
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
