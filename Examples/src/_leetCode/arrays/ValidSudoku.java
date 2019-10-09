package _leetCode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        try {
            // 1. Each row must contain the digits 1-9 without repetition
            checkRows(board);
            // 2. Each column must contain the digits 1-9 without repetition.
            checkColumns(board);
            //3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
            checkSubBoxes(board);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void checkRows(char[][] board) {
        for (char[] row : board) {
            if (!isValid(toList(row))) {
                throw new IllegalArgumentException("not valid row");
            }
        }
    }

    private static void checkColumns(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<Character> row = new ArrayList<>();
            for (int n = 0; n < 9; n++) {
                if (board[n][i] != '.') {
                    row.add(board[n][i]);
                }
            }
            if (!isValid(row)) {
                throw new IllegalArgumentException("not valid row");
            }
        }
    }

    private static void checkSubBoxes(char[][] board) {
        for (int i = 0; i < 9; i = i + 3) {
            for (int n = 0; n < 9; n = n + 3) {
                List<Character> row = new ArrayList<>();
                for (int x = i; x < i+3; x++) {
                    for (int y = n; y < n+3; y++) {
                        if (board[x][y] != '.') {
                            row.add(board[x][y]);
                        }
                    }
                }
                if (!isValid(row)) {
                    throw new IllegalArgumentException("not valid row");
                }
            }

        }
    }

    private static boolean isValid(List<Character> list) {
        Set<Character> set = new HashSet<>(list);
        return list.size() == set.size();
    }

    private static List<Character> toList(char[] chars) {
        ArrayList<Character> result = new ArrayList<Character>();
        for (char ch : chars) {
            if (ch != '.') {
                result.add(ch);
            }
        }
        return result;
    }
}
