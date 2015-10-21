package collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mdmytiaha on 21-Oct-15.
 */
public class Coolections {
    public static void main(String[] args) {
        Set<MyPoint2D> set = new TreeSet<>();
        set.add(new MyPoint2D(0, 10));
        set.add(new MyPoint2D(0, 11));
        set.add(new MyPoint2D(10, 10));
        System.out.println(set);

        Set<String> strSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int diff = o2.length() - o1.length();
                if(diff!=0) {
                    return diff;
                }
                return o1.compareTo(o2);
            }
        });
        strSet.add("a");
        strSet.add("ax");
        strSet.add("ay");
        strSet.add("x");
        strSet.add("b");
        strSet.add("c");
        strSet.add("d");
        strSet.add("e");

        System.out.println(strSet);
    }
}
