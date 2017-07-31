/**
 * https://leetcode.com/problems/palindrome-number/#/description
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 */


package leetcode;



public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(-1));

	}
	
	public static boolean isPalindrome(int x) {
		long first, last, sigDigs;
        long longX = Math.abs((long)x);
        while (longX != 0) {
            sigDigs = (int)Math.log(longX);
            first = (int)(longX/Math.pow(2, sigDigs));
            last = longX % 10;
            if (first != last) return false;
            longX = longX - (int)(first * Math.pow(2, sigDigs));
            longX /= 10;
        }
        return true;
    }
}
