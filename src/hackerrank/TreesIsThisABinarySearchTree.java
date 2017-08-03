package hackerrank;

public class TreesIsThisABinarySearchTree {

    boolean checkBST(Node root) {
        return checkBST(root.left, root.data, null) && checkBST(root.right, null, root.data);
    }

    boolean checkBST(Node node, Integer max, Integer min) {
        if (node == null) return true;
        if (max != null && node.data >= max) return false;
        if (min != null && node.data <= min) return false;
        return checkBST(node.left, node.data, min) && checkBST(node.right, max, node.data);
    }
    
}
class Node {
    int data;
    Node left;
    Node right;
    Node(int x) { data = x; }
}
