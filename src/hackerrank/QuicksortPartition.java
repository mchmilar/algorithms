package hackerrank;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/quicksort1
 * @author Mark Chmilar
 */
public class QuicksortPartition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int pivot = in.nextInt();
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int number = in.nextInt();
            if (number < pivot)
                left.add(number);
            else 
                right.add(number);
        }
        left.add(pivot);
        left.addAll(right);
        for (Integer number : left)
            System.out.print(number + " ");
        in.close();
    }
}