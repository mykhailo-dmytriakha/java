package _leetCode.strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        isPalindrome("0P");
    }

    public static boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        String formatedString = s.replaceAll("[^A-Za-z]+", "");

        char[] chars = formatedString.toLowerCase().toCharArray();

        int i = 0;
        int n = chars.length - 1;
        while (i<n){
            if(chars[i]!=chars[n]){
                return false;
            }
            i++;
            n--;
        }
        return true;
    }
}
