package _hackerrank.collections;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Михаил on 20.02.2016.
 */
public class Java1DArrayHard {
    public static final int INITIAL_STEP = 0;
    private static final int STEP_FORWARD = 1;
    private static final int STEP_BACK = -1;
    private static int STEP_JUMP;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > INITIAL_STEP) {
            int length = in.nextInt();
            STEP_JUMP = in.nextInt();
            int[] array = getArray(in, length);
            System.out.println(isPossibleWinTheGame(array));
            testCases--;
        }
    }

    private static String isPossibleWinTheGame(int[] array) {
        ArrayList<Integer> visitedIndexes = new ArrayList<>();
        visitedIndexes.add(INITIAL_STEP);
        if (isWinStep(array, INITIAL_STEP + STEP_FORWARD, visitedIndexes) ||
                isWinStep(array, INITIAL_STEP + STEP_JUMP, visitedIndexes)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static boolean isWinStep(int[] array, int currentIndex, ArrayList<Integer> visitedIndexes) {
        int length = array.length;
        if (currentIndex >= length) {
            return true;
        }
        if (array[currentIndex] == 1 /*fault step*/ || visitedIndexes.contains(currentIndex)) {
            return false;
        }
        int forwardIndex = currentIndex + STEP_FORWARD;
        int backIndex = currentIndex + STEP_BACK;
        int jumpIndex = currentIndex + STEP_JUMP;
        if (jumpIndex >= length || forwardIndex == length) {
            return true;
        } else {
            visitedIndexes.add(currentIndex);
            return isWinStep(array, jumpIndex, visitedIndexes) ||
                    isWinStep(array, forwardIndex, visitedIndexes) ||
                    isWinStep(array, backIndex, visitedIndexes);
        }
    }

    private static int[] getArray(Scanner in, int length) {
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = in.nextInt();
        }
        return res;
    }
}
