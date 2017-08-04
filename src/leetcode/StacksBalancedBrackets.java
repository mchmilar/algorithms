package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/ctci-balanced-bracketsg
 * Created by Mark Chmilar on 8/4/17.
 */
public class StacksBalancedBrackets {
    public static boolean isBalanced(String expression) {
        if (expression.isEmpty() || expression.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isClosing(c)) {
                if (stack.empty() || !opposite(c, stack.peek())) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    private static boolean opposite(char a, char b) {
        switch(a) {
            case '}': return b == '{';
            case ']': return b == '[';
            case ')': return b == '(';
            default: return false;
        }
    }

    private static boolean isClosing(char c) {
        return c == ']' || c == '}' || c == ')';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
