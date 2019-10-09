package _leetCode.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    private List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        addNodeToList(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void addNodeToList(TreeNode root) {

        if (root.left != null) {
            addNodeToList(root.left);
            list.add(root.val);
        } else {
            list.add(root.val);
        }
        if (root.right != null) {
            addNodeToList(root.right);
        }
        return;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
