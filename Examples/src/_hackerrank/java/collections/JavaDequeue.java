package _hackerrank.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

/**
 * task description
 * <b>https://www.hackerrank.com/challenges/java-dequeue/submissions/code/17812480</b>
 */
public class JavaDequeue {
    private static Deque<Integer> numbers;
    private static HashMap<Integer, Integer> uniqueNumbers;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 0;
        int n = in.nextInt();
        int m = in.nextInt();
        numbers = new ArrayDeque<>(n);
        uniqueNumbers = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            addElement(num);
            if (numbers.size() == m) {
                Integer uniqueNumber = getAmountOfUniqueNumbers();
                if (uniqueNumber > max) {
                    max = uniqueNumber;
                }
                removeElement();
            }
        }
        System.out.println(max);
    }

    private static void removeElement() {
        Integer num = numbers.removeFirst();
        Integer value = uniqueNumbers.get(num);
        if (value == 1) {
            uniqueNumbers.remove(num);
        } else {
            uniqueNumbers.put(num, --value);
        }
    }

    private static void addElement(int num) {
        numbers.addLast(num);

        Integer value = uniqueNumbers.get(num);
        uniqueNumbers.put(num, (null == value) ? 1 : ++value);
    }

    private static Integer getAmountOfUniqueNumbers() {
        return uniqueNumbers.size();
    }
}
