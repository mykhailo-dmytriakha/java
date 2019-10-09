package _leetCode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        IntStream.of(nums).forEach(num -> {
            Integer totalCount = map.getOrDefault(num, 0);
            totalCount++;
            map.put(num, totalCount);
        });
        Integer key = map.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
        return key;
    }
}
