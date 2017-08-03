package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class TriesContacts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node trie = new Node();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            performOp(op, contact, trie);
        }
    }
    
    private static void performOp(String op, String contact, Node trie) {
        if ("add".equals(op)) {
            trie.insert(contact);
        }
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node('*');
    }

    public void insert(String word) {
        root.insert(word);
    }
}

class Node {
    char c;
    HashMap<Character, Node> children;
    boolean isCompleteWord;

    public Node(char c) {
        this(c, false);
    }

    public Node(char c, boolean isCompleteWord) {
        children = new HashMap<>();
        this.isCompleteWord = isCompleteWord;
        c = c;
    }

    private Node(String word) {
        children = new HashMap<>();
        c = word.charAt(0);
        if (word.length() == 1) {
            isCompleteWord = true;
        }
    }
    
    public void insert(String word) {
        if (children.containsKey(word.charAt(0))) {
            if (word.length() == 1) {
                
            }
        }
    }
}
