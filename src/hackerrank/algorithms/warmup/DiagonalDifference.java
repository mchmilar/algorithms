package hackerrank.algorithms.warmup;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                if (i == j && i + j == n-1) {
                    // middle cell, do nothing
                } else if (i == j) {
                    result += num;
                } else if (i + j == n-1) {
                    result -= num;
                }
            }
        }
        System.out.println(Math.abs(result));
    }
    
}
