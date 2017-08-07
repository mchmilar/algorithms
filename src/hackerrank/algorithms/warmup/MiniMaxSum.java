package hackerrank.algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] a = new long[5];
        for (int i = 0; i < 5; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        long min = a[0] + a[1] + a[2] + a[3];
        long max = a[1] + a[2] + a[3] + a[4];
        System.out.println(min + " " + max);
    }
}