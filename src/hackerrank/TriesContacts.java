package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-contacts
 * @author Mark Chmilar
 *
 */
public class TriesContacts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TrieNode trie = new TrieNode();
        StringBuilder sb = new StringBuilder();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if ("add".equals(op)) {
                trie.insert(contact);
            } else if ("find".equals(op)) {
                sb.append(trie.matchCount(contact));
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}



class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isCompleteWord;
    boolean addedChildSinceCount;
    int fullChildWords;
    
    
    public TrieNode() {
        children = new HashMap<>();
        isCompleteWord = false;
        addedChildSinceCount = true;
    }
    
    public int matchCount(String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        TrieNode dfsRoot = prefixSubset(needle);
        if (dfsRoot == null)
            return 0;
        return dfsRoot.dfsCount(0);
    }
    
    private int dfsCount(int count) {
        if (addedChildSinceCount) {
            for (TrieNode t : children.values()) {
                fullChildWords += t.dfsCount(count);
            }
            if (isCompleteWord)
                ++count;
        }
        addedChildSinceCount = false;
        return count + fullChildWords;
    }
    
    
    
    public TrieNode prefixSubset(String needle) {
        TrieNode child = children.get(needle.charAt(0));
        if (child == null)
            return null;
        if (needle.length() == 1)
            return child;
        return child.prefixSubset(needle.substring(1));
    }

    
    public void insert(String word) {
        addedChildSinceCount = true;
        fullChildWords = 0;
        char c = word.charAt(0);
        TrieNode child = children.get(c);
        if (child == null) {
            child = new TrieNode();
            children.put(c, child);
        }
        if (word.length() == 1) {
            child.isCompleteWord = true;
        } else {
            child.insert(word.substring(1));
        }
    }
}
