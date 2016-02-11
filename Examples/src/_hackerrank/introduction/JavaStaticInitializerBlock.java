package _hackerrank.introduction;

import java.util.Scanner;

/**
 * Created by mdmytiaha on 10-Feb-16.
 */
public class JavaStaticInitializerBlock {
    private static int B;
    private static int H;
    private static Boolean flag = getFlag();

    static Boolean getFlag() {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        if (B <= 0 || H <= 0) {
            try {
                throw new Exception("Breadth and height must be positive");
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.println(area);
        }
    }
}
