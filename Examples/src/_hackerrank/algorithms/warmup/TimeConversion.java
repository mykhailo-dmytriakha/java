package _hackerrank.algorithms.warmup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * <pre>
 * https://www.hackerrank.com/challenges/time-conversion
 * Given a time in AM/PM format, convert it to military (24-hour) time.
 * Note: Midnight is 12:00:00AM on a 12-hour clock and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock and 12:00:00 on a 24-hour clock.
 *
 * Input Format
 * A time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM), where 01≤hh≤12.
 *
 * Sample Input
 * Convert and print the given time in 24-hour format, where 00≤hh≤23.
 *
 * Sample Output
 * 07:05:45PM
 *
 * Explanation
 * 19:05:45
 * </pre>
 */
public class TimeConversion {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        Date date = new SimpleDateFormat("hh:mm:ssa").parse(time);
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
    }
}
