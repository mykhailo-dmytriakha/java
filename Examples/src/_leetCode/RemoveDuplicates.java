package _leetCode;

public class RemoveDuplicates {

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
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
        if (nums.length == 0) {
            return 0;
        }
        int val = nums[0], length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[length] = nums[i];
                length++;
                val = nums[i];
            }
        }
        return length;
    }
}