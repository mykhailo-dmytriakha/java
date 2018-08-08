package _hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * <pre>
 * https://www.hackerrank.com/challenges/plus-minus
 * Given an array of integers, calculate which fraction of the elements are positive, negative, and zeroes, respectively. Print the decimal value of each fraction.
 *
 * Input Format
 * The first line, N, is the size of the array.
 * The second line contains NN space-separated integers describing the array of numbers (A1,A2,A3,⋯,AN).
 *
 * Output Format
 * Print each value on its own line with the fraction of positive numbers first, negative numbers second, and zeroes third.
 *
 * Sample Input
 * 6
 * -4 3 -9 0 4 1
 *
 * Sample Output
 * 0.500000
 * 0.333333
 * 0.166667
 *
 * Explanation
 *
 * There are 3 positive numbers, 2 negative numbers, and 1 zero in the array.
 * The fraction of the positive numbers, negative numbers and zeroes are 3/6=0.500000, 2/6=0.333333 and 1/6=0.166667, respectively.
 * </pre>
 */
public class PlusMinus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        int posCount = 0;
        int zeroCount = 0;
        int negCount = 0;

        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
            if (arr[arr_i] == 0) {
                zeroCount++;
            } else if (arr[arr_i] > 0) {
                posCount++;
            } else {
                negCount++;
            }
        }

        format((double)posCount / n);
        format((double)negCount / n);
        format((double)zeroCount / n);
    }

    private static void format(double value) {
        System.out.printf("%.6f\n", value);
    }
}
