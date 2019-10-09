package _leetCode.arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        for (int i = 0; i <k; i++){
            rotateArrOneTime(nums);
        }
    }
    private static void rotateArrOneTime(int[] array){
        int value = array[array.length-1];
        for(int i = array.length-1; i > 0; i--){
            array[i] = array[i-1];
        }
        array[0] = value;
    }
}
