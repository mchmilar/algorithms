/**
 * https://leetcode.com/problems/longest-common-prefix/#/description
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println("result is: " + longestCommonPrefix(new String[]{"",""}));

	}
	
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String result = "";
        boolean done = false;
        int j = 1;
        while (!done) {
        	String nextChar = "";
        	for (int i = 0; i < strs.length; i++) {
        		if (j > strs[i].length() ||!strs[0].substring(j-1, j).equals(strs[i].substring(j-1,j))) {
        			done = true;
        		}
        	}
        	if (!done)
        		result = strs[0].substring(0, j);
        	j++;
        }
        return result;
    }

}
