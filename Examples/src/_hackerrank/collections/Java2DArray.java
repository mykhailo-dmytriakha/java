package _hackerrank.collections;

import java.util.Scanner;

/**
 * Created by Михаил on 20.02.2016.
 *
 * <p>task description https://www.hackerrank.com/challenges/java-2d-array </p>
 */
public class Java2DArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(getMaxOfHourGlass(arr));
    }

    private static int getMaxOfHourGlass(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                int amountOfHourGlass = getAmountOfHourGlass(arr, i, j);
                if(amountOfHourGlass > max) {
                    max = amountOfHourGlass;
                }
            }
        }
        return max;
    }

    private static int getAmountOfHourGlass(int[][] arr, int i, int j) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                arr[i + 1][j + 1] +
                arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
    }
}
