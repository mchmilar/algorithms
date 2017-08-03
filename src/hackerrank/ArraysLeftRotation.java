package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 * @author Mark Chmilar
 *
 */
public class ArraysLeftRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[l];
        for(int a_i=0; a_i < l; a_i++){
            int newIndex = (a_i + l - d) % l;
            a[newIndex] = in.nextInt();
        }
        for (int i = 0; i < l; i++) {
            System.out.print(a[i] + ((i == l - 1) ? "" : " "));
        }
	}

}
