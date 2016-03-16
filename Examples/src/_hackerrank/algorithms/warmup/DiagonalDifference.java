package _hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 <pre>
 https://www.hackerrank.com/challenges/diagonal-difference

 Given a square matrix of size N×N, calculate the absolute difference between the sums of its diagonals.

 Input Format
 The first line contains a single integer, N. The next N lines denote the matrix's rows, with each line containing N space-separated integers describing the columns.

 Output Format
 Print the absolute difference between the two sums of the matrix's diagonals as a single integer.

 Sample Input
 3
 11 2 4
 4 5 6
 10 8 -12

 Sample Output
 15
 </pre>
 */
public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }

        int mainDiagonal = getSumOfDiagonal(a, Diagonal.MAIN);
        int antiDiagonal = getSumOfDiagonal(a, Diagonal.ANTI);
        System.out.println(Math.abs(mainDiagonal - antiDiagonal));
    }

    private static int getSumOfDiagonal(int [][] arr, Diagonal type) {
        return (type == Diagonal.MAIN) ? getSumOfMainDiagonal(arr) : getSumOfAntiDiagonal(arr);
    }

    private static int getSumOfAntiDiagonal(int[][] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length;  i++){
            sum += arr[i][i];
        }
        return sum;
    }

    private static int getSumOfMainDiagonal(int[][] arr){
        int sum = 0;
        int length = arr.length - 1;
        for(int i = 0; i <= length; i++){
            sum += arr[length - i][i];
        }
        return sum;
    }
}

enum Diagonal{
    MAIN, ANTI
}
