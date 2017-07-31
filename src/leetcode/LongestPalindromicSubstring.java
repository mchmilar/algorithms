/* https://leetcode.com/problems/longest-palindromic-substring/#/description
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 */

package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));

	}
	
	public static String longestPalindrome(String s) {
		for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (i % 2 == 0) {
                    // even length check
                    if (s.substring(j, i/2 + j).equals(new StringBuilder(s.substring(i/2 + j, i+j)).reverse().toString()))
                        return s.substring(j, i+j);
                } else {
                    // odd length check
                    if (s.substring(j, i/2 + j).equals(new StringBuilder(s.substring(i/2 + 1 + j, i+j)).reverse().toString()))
                        return s.substring(j, i+j);
                }
            }
        }
        return s.substring(0,1);
	}

}
