package _mains;

import utils.math.MathUtil;

/**
 * Created by mdmytiaha on 20-Nov-15.
 */
public class MainPrime {
    public static void main(String[] args) {

        int largestPrimeFactor = MathUtil.getLargestPrimeFactor(600_851_475_143L);
        System.out.println(largestPrimeFactor);
    }
}
