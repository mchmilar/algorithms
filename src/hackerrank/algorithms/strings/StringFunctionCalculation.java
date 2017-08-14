package hackerrank.algorithms.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringFunctionCalculation {
    static int maxValue(String t) {
        String[] suffixes = suffix(t);
        int[] lcp = lcp(suffixes);
        int result = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            for (int j = i + 1; j <= t.length(); j++) {
                System.out.println(j - i);
                int count = search(t, i, j, suffixes, lcp);
                if (count == 1) {
                    if (t.length() - i > result)
                        result = t.length() - i;
                    break;
                }
                if (count * (j - i) > result)
                    result = count * (j - i);
            }
        }
        return result;
        
    }

    static int[] lcp(String[] suffixes) {
        int[] lcp = new int[suffixes.length];
        for (int i = 1; i < lcp.length; i++) {
            int count = 0;
            String lead = suffixes[i];
            String tail = suffixes[i-1];
            for (int j = 0; j < lead.length() && j < tail.length(); j++) {
                if (lead.charAt(j) == tail.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            lcp[i] = count;
        }
        return lcp;
    }

    static int myCompareTo(String string, int start, int end, String suffix) {
        int n = Math.min(end-start, suffix.length());
        for (int i = 0; i < n; i++) {
            if (string.charAt(i+start) < suffix.charAt(i)) return -1;
            if (string.charAt(i+start) > suffix.charAt(i)) return +1;
        }
        return (end - start) - suffix.length();
    }
    
    static int search(String string, int begin, int end, String[] suffixes, int[] lcp) {
        int l = 0, r = suffixes.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (myCompareTo(string, begin, end, suffixes[mid]) > 0)
                l = mid + 1;
            else
                r = mid;
        }
        int start = l;
        l++;
        r = suffixes.length;
        while (l < r) {
            if (lcp[l] >= (end - begin))
                l++;
            else
                break;
        }
        return l - start;
    }
    
    
    
    static String[] suffix(String t) {
        String[] s = new String[t.length()];
        for (int i = 0; i < t.length(); i++) {
            //System.out.println(i);
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
