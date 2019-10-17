package _leetCode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"dog","racecar","car"});
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        int index = 0;

        int minLength = Integer.MAX_VALUE;
        for (String  str:strs){
            int length = str.length();
            if (length < minLength) {
                minLength = length;
            }
        }
        while (index < minLength) {
            for (String str : strs) {
                set.add(str.substring(index, index + 1));
            }
            if(set.size() == 1){
                sb.append(set.toArray()[0]);
                set = new HashSet<>();
            } else {
                return sb.toString();
            }
            index++;
        }
        return sb.toString();
    }
}
