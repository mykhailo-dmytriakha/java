package _leetCode.strings;

public class ReverseInteger {
    public static void main(String[] args) {
//        System.out.println(reverse(-120));
//        System.out.println(reverse(0));
//        System.out.println(reverse(1534236469));
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }
        String number = x + "";
        char[] chars = number.toCharArray();
        reverseString(chars);

        if (chars[0] == '0') {
            char[] res = new char[chars.length - 1];
            System.arraycopy(chars, 1, res, 0, res.length);
            chars = res;
        }
        try {
            if (chars[chars.length - 1] == '-') {
                char[] res = new char[chars.length - 1];
                System.arraycopy(chars, 0, res, 0, res.length);
                return Integer.parseInt(new String(res)) * -1;
            }

            return Integer.parseInt(new String(chars));
        } catch (Exception e) {
            return 0;

        }
    }

    public static void reverseString(char[] s) {
        int startIndex = 0;
        int endIndex = s.length - 1;

        while (startIndex < endIndex) {
            char temp = s[startIndex];
            s[startIndex] = s[endIndex];
            s[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
