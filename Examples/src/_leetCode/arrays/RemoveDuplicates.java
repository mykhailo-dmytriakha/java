package _leetCode.arrays;

public class RemoveDuplicates {

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result.append(number).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int ret = removeDuplicates(nums);
        String out = integerArrayToString(nums, ret);

        System.out.print(out);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int e = nums.length;
        int i;
        for(i = 1; i < e; i++){
            if(nums[i] == nums[i-1]){
                putValueToTheEndAndShift(nums, i);
                e--;
                i--;
            }
        }
        return i;
    }

    private static void putValueToTheEndAndShift(int[] array, int index){
        int value = array[index];
        for(int i = index; i<array.length-1; i++){
            array[i] = array[i+1];
        }
        array[array.length - 1] = value;
    }
}
