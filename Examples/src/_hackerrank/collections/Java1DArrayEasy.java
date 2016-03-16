package _hackerrank.collections;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Михаил on 19.02.2016.
 */
public class Java1DArrayEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int counter = 0;
        for (int fromIndex = 0; fromIndex < n; fromIndex++) {
            for (int toIndex = fromIndex + 1; toIndex <= n; toIndex++) {
                if (sumOfSubArray(array, fromIndex, toIndex) < 0) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    private static long sumOfSubArray(int[] array, int from, int to) {
        int[] subArray = Arrays.copyOfRange(array, from, to);
        return sumOfArray(subArray);
    }

    private static long sumOfArray(int[] subArray) {
        long sum = 0;
        for (int i : subArray) {
            sum += i;
        }
        return sum;
    }
}
