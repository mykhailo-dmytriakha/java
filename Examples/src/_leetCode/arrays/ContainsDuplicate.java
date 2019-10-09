package _leetCode.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        containsDuplicate(nums);

    }

    public static boolean containsDuplicate(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);
        return list.size() == set.size();
    }
}
