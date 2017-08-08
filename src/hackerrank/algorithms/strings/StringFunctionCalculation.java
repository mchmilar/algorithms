package hackerrank.algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFunctionCalculation {
    static int maxValue(String t) {
        String[] suffixes = suffix(t);
        int result = 0;
        for (int i = 0; i < t.length(); i++) {
            for (int j = i + 1; j < t.length(); j++) {
                String ss = t.substring(i, j);
                int count = search(ss, suffixes);
                if (count * ss.length() > result)
                    result = count * ss.length();
            }
        }
        return result;
        
    }
    
    static int search(String s, String[] suffixes) {
        int l = 0, r = s.length();
        while (l < r) {
            int mid = (l + r) / 2;
            if (s.compareTo(suffixes[mid]) > 0)
                r = mid;
        }
    }
    
    
    
    static String[] suffix(String t) {
        String[] s = new String[t.length()];
        for (int i = 0; i < t.length(); i++) {
            s[i] = t.substring(i);
        }
        Arrays.sort(s);
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.next();
        int result = maxValue(t);
        System.out.println(result);
        in.close();
    }
}
