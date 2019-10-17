package _leetCode.strings;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String result = "";
        while (n > 0) {
            result = getNextValue(result);
            n--;
        }
        return result;

    }

    private static String getNextValue(String str) {
        if (str.isEmpty()) {
            return "1";
        }
        String[] nums = str.split("");
        StringBuilder sb = new StringBuilder();

        String digit = nums[0];
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            String num = nums[i];
            if (num.equals(digit)) {
                count++;
            } else {
                sb.append(count).append(digit);
                digit = num;
                count = 1;
            }
        }
        sb.append(Integer.toString(count)).append(digit);
        return sb.toString();
    }
}
