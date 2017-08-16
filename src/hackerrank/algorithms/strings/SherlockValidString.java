package hackerrank.algorithms.strings;

import java.util.HashMap;
import java.util.Scanner;

public class SherlockValidString {
    static String isValid(String s){
        if (s.length() < 4)
            return "YES";
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        boolean flag = false;
        for (int i = 1; i < 26; i++) {
            if (map[i-1] == 0) break;
            int diff = Math.abs(map[i] - map[i-1]);
            if (diff > 1) return "NO";
            if (flag && diff > 0)
        }
        return "";
    }
    
    static int getCharIndex(char c) {
        return c - 'a';
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
