package _leetCode.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("cc"));
    }

    public static int firstUniqChar(String s) {
        Map<Character, IndexFreq> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (map.containsKey(c)) {
                IndexFreq indexFreq = map.get(c);
                indexFreq.total++;
            } else {
                map.put(c, new IndexFreq(i, 1));
            }
        }

        if (map.size() == 0) {
            return -1;
        }
        return map.values().stream()
                .filter(value -> value.total == 1)
                .min(Comparator.comparing(value -> value.index))
                .orElse(new IndexFreq(-1, -1)).index;
    }

}

class IndexFreq {
    int index;
    int total;

    public IndexFreq(int index, int total) {

        this.index = index;
        this.total = total;
    }
}
