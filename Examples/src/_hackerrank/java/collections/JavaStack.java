package _hackerrank.java.collections;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Михаил on 22.02.2016.
 * <p>task description https://www.hackerrank.com/challenges/java-stack</p>
 */
public class JavaStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input));
        }
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0, n = str.length(); i < n; i++) {
            Character c = str.charAt(i);
            if (stack.isEmpty())
                stack.push(c);
            else if (isPairs(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static boolean isPairs(Character openBracket, Character closeBracket) {
        switch (openBracket){
            case '(':
                return closeBracket == ')';
            case '[':
                return closeBracket == ']';
            case '{':
                return closeBracket == '}';
            default:
                return false;
        }
    }
}
