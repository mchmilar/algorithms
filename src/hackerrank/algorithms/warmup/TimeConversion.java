package hackerrank.algorithms.warmup;

import java.util.Scanner;

public class TimeConversion {
    static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        if (hour == 12)
            hour = 0;
        if ("pm".equalsIgnoreCase(s.substring(8)))
            hour += 12;
        int minute = Integer.parseInt(s.substring(3, 5));
        int second = Integer.parseInt(s.substring(6, 8));
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
