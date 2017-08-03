package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mark on 8/2/17.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }


    private void dfs(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) return;
        if (result.size() > level) {
            result.get(level).add(node.val);
        } else {
            result.add(new ArrayList<>(Arrays.asList(node.val)));
        }
        dfs(result, node.left, level + 1);
        dfs(result, node.right, level + 1);

    }


    private class TreeNode {
        int val;
        BinaryTreeLevelOrderTraversal.TreeNode left;
        BinaryTreeLevelOrderTraversal.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
