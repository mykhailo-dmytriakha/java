package _hackerrank.java.bigNumber;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Михаил on 18.02.2016.
 */
public class JavaBigDecimal {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return new BigDecimal(s2).compareTo(new BigDecimal(s1));
            }
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
