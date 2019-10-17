package _leetCode.strings;

public class Implement_strStr {
    public static void main(String[] args) {
        strStr("hello", "ll");
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        String[] word = haystack.split("");
        String[] part = needle.split("");
        for (int i = 0; i < word.length; i++) {
            if(i + part.length > word.length){
                return -1;
            }

            boolean isMatching = checkMatching(word, i, part);
            if(isMatching){
                return i;
            }
        }
        return -1;
    }

    private static boolean checkMatching(String[] word, int i, String[] part) {
        for (int n = 0; n < part.length; n++, i++) {
            if(!part[n].equals(word[i])){
                return false;
            }
        }
        return true;
    }
}
