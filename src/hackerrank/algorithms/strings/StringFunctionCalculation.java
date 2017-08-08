package hackerrank.algorithms.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFunctionCalculation {
    static int maxValue(String t) {
        int result = 0;
        for (int i = 0; i < t.length(); i++) {
            for (int j = i + 1; j < t.length(); j++) {
                String ss = t.substring(i, j);
                int count = 0;
                for (int k = 0; k <= (t.length() - ss.length()); k++) {
                    if (t.indexOf(ss, k) != -1)
                        count++;
                }
                int score = count * (ss.length());
                if (score > result)
                    result = score;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.next();
        int result = maxValue(t);
        System.out.println(result);
        in.close();
    }
}
