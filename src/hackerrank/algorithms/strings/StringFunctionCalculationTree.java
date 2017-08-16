package hackerrank.algorithms.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class StringFunctionCalculationTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.next();
        SuffixNode tree = buildSuffixTree(t);
        int result = 0;
        for (int i = 0; i < t.length(); i++) {
            for (int j = i+1; j <= t.length(); j++) {
                int count = tree.findCount(t, i, j);
                if (count == 1) {
                    if (t.length() - i > result)
                        result = t.length() - i;
                    break;
                }
                result = Math.max(result, (j - i) * count);
                
            }
        }
        System.out.println(result);
        in.close();
    }
    
    private static SuffixNode buildSuffixTree(String s) {
        SuffixNode result = new SuffixNode();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i));
        }
        result.dfsCount();
        return result;
    }
    
    public static class SuffixNode {
        HashMap<Character, SuffixNode> children = new HashMap<>();
        boolean isFullSuffix = false;
        int numMatches = 0;
        
        private SuffixNode getNode(char c) {
            return children.get(c);
        }
        
        private void setNode(char c, SuffixNode node) {
            children.put(c, node);
        }
        
        public void add(String s) {
            add(s, 0);
        }
        
        private void add(String s, int index) {
            if (index == s.length()) return;
            SuffixNode child = getNode(s.charAt(index));
            if (child == null){
                child = new SuffixNode();
                setNode(s.charAt(index), child);
            }
            if (index == s.length() - 1)
                child.isFullSuffix = true;
            child.add(s, index + 1);
        }
        
        public int dfsCount() {
            for (SuffixNode t : children.values()) {
                numMatches = t.dfsCount();
            }
            if (isFullSuffix)
                ++numMatches;
            return numMatches;
        }
        
        public int findCount(String s, int i, int j) {
            if (i == j)
                return numMatches;
            SuffixNode child = getNode(s.charAt(i));
            if (child == null)
                return 0;
            return child.findCount(s, i + 1, j);
        }
    }
}

