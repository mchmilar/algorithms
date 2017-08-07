package hackerrank.algorithms.warmup;

import java.util.Scanner;

public class PlusMinus {
    public static void main(String args[]) {
        int[] counts = new int[3];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (num > 0) counts[0]++;
            else if (num < 0) counts[1]++;
            else if (num == 0) counts[2]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println((double)counts[i]/n);
        }
    }
    
}
