package _hackerrank.java.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Михаил on 22.02.2016.
 * <p>task description https://www.hackerrank.com/challenges/phone-book</p>
 */
public class JavaMap {
    public static void main(String[] args) {
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String answer = "Not found";
            String s = in.nextLine();
            if (phoneBook.containsKey(s))
                answer = s + "=" + phoneBook.get(s);
            System.out.println(answer);
        }
    }
}
