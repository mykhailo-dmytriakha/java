package _hackerrank.collections;

import java.util.*;

public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 0;
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> numbers = new ArrayDeque<>(n);
        Map<Integer, Integer> uniqueNumbers = new HashMap<>(m);

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            numbers.add(num);
            if(numbers.size() == m){
                Integer uniqueNumber = getAmountOfUniqueNumbers(numbers);
                if(uniqueNumber >max) {
                    max = uniqueNumber;
                }
                numbers.pollFirst();
            }
        }
        System.out.println(max);
    }

    private static Integer getAmountOfUniqueNumbers(Deque<Integer> subArray) {
        return new HashMap<Integer, Integer>().size();
    }
}
