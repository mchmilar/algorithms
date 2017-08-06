package hackerrank;

import java.util.Scanner;

/**
 * Created by mark on 8/6/17.
 */
public class QuicksortSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[in.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int pivot = a[left];
        int index = partition(a, left, right, pivot);
        quickSort(a, left, index - 1);
        for (int i = left; i < index; i++) {
            System.out.print(a[i] + ((i == index - 1) ? "\n" : " "));
        }
        quickSort(a, index, right);
    }

    private static int partition(int[] a, int left, int right, int pivot) {
        int leftStart = left;
        int rightStart = right;
        while (left <= right) {
            while (a[left] < pivot)
                ++left;
            while (a[right] > pivot)
                --right;
            if (left <= right) {
                swap(a, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    private static void swap(int[] a, int left, int right) {
        int tmp = a[right];
        a[right] = a[left];
        a[left] = tmp;
    }
}
