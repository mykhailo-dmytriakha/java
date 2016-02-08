package _hackerrank;

import java.util.Scanner;

/**
 * Created by mdmytiaha on 08-Feb-16.
 */
public class JavaLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcaseCounter = scanner.nextInt();
        scanner.nextLine();

        while (testcaseCounter != 0) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();

            int result = a;
            for (int i = 0; i < n; i++) {
                result += calculateResult(b, i);
                System.out.print(result + " ");
            }
            System.out.print("\n");

            testcaseCounter--;
        }
    }

    private static int calculateResult(int b, int n) {
        return (int) (Math.pow(2, n) * b);
    }
}
