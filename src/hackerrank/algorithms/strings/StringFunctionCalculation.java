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
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            for (int j = i + 1; j <= t.length(); j++) {
                String ss = t.substring(i, j);
                int count = 0;
                Integer memoInt = memo.get(ss);
                if (memoInt == null)
                    count = search(ss, suffixes, lcp);
                else
                    count = memoInt.intValue();
                if (count == 0)
                    break;
                if (count * ss.length() > result)
                    result = count * ss.length();
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
    
    static int search(String s, String[] suffixes, int[] lcp) {
        int l = 0, r = suffixes.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (s.compareTo(suffixes[mid]) > 0)
                l = mid + 1;
            else
                r = mid;
        }
        int start = l;
        l++;
        r = suffixes.length;
        while (l < r) {
            if (lcp[l] >= s.length())
                l++;
            else
                break;
        }
        return l - start;
    }
    
    
    
    static String[] suffix(String t) {
        String[] s = new String[t.length()];
        for (int i = 0; i < t.length(); i++) {
            System.out.println(i);
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
