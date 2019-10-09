package _leetCode.arrays;

public class PlusOne {
    public static void main(String[] args) {
        plusOne(new int[]{9, 9, 9});
    }

    public static int[] plusOne(int[] digits) {
        boolean overTen = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num;
            if (i == digits.length - 1) {
                num = digits[i] + 1;
            } else {
                num = digits[i];
            }
            if (overTen) {
                num++;
                overTen = false;
            }
            if (num >= 10) {
                overTen = true;
                digits[i] = num - 10;
            } else {
                digits[i] = num;
            }
        }

        if (overTen) {
            int bigger[] = new int[digits.length + 1];
            System.arraycopy(digits, 0, bigger, 1, digits.length);
            bigger[0] = 1;
            return bigger;
        } else {
            return digits;
        }
    }
}
