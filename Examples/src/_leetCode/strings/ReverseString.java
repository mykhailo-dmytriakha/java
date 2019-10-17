package _leetCode.strings;

public class ReverseString {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
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
