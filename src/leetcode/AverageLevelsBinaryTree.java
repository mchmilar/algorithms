package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 8/2/17.
 */
public class AverageLevelsBinaryTree {

    List<Double> result;
    Map<Integer, double[]> data;
    public List<Double> averageOfLevels(TreeNode root) {
        result = new ArrayList<>();
        data = new HashMap<>();
        inorder(root, 0);
        int i = 0;
        for (double[] pair : data.values()) {
           result.add(i, pair[1]/pair[0]);
           i++;
        }
        return result;
    }

    private void inorder(TreeNode node, int level) {
        if (node == null) return;
        inorder(node.left, level + 1);
        if (data.get(level) == null) {
            data.put(level, new double[]{1, node.val});
        } else {
            data.get(level)[0]++;
            data.get(level)[1] += node.val;
        }
        inorder(node.right, level + 1);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
