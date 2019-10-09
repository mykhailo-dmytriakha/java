package _leetCode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    Queue<TreeNode> queue = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            queue = collectLeveNodeValues(queue);
        }

        return result;
    }

    private Queue<TreeNode> collectLeveNodeValues(Queue<TreeNode> queue) {
        List<Integer> levelResult = new ArrayList<>();
        Queue<TreeNode> levelQueue = new ArrayDeque<>();
        queue.stream().forEach(n -> {
            if (n.left != null) {
                levelQueue.add(n.left);
            }
            if (n.right != null) {
                levelQueue.add(n.right);
            }
            levelResult.add(n.val);
        });
        result.add(levelResult);

        return levelQueue;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
