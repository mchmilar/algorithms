/*
 * https://leetcode.com/problems/implement-strstr/#/description
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

package leetcode;

public class ImplementStrStr {

	public static void main(String[] args) {
		System.out.println(strStr("a", "a"));

	}
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if (needle.length() == haystack.length()) 
        if (needle.length() == 0) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, needle.length() + i).equals(needle))
                return i;
        }
        return -1;
    }
}
