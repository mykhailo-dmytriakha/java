package _hackerrank;

import java.util.Scanner;

/**
 * Created by mdmytiaha on 10-Feb-16.
 */
public class JavaEndOfFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (scanner.hasNext()){
            counter++;
            System.out.println(counter + " "+scanner.nextLine());
        }
    }
}
