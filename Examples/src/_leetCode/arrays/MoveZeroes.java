package _leetCode.arrays;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        IntStream.of(nums).boxed().forEach(System.out::print);
    }

    public static void moveZeroes(int[] nums) {
        for (int zPointer = 0; zPointer<nums.length; zPointer++){
            if(nums[zPointer] == 0){
                for(int n = zPointer + 1; n < nums.length; n++){
                    if(nums[n] != 0){
                        nums[zPointer] = nums[n];
                        nums[n]=0;
                        break;
                    }
                    if(n == nums.length-1)
                        return;
                }
            }
        }
    }
}
