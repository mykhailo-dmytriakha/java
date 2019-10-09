package _leetCode.trees;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if((n1 == null && n2!=null) ||
           (n1 != null && n2==null) ||
           (n1.val != n2.val)){
            return false;
        } else{
            return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
