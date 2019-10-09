package _leetCode.trees;

import java.util.Arrays;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};
        sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else {
            int topIndex = nums.length / 2;
            int[] leftArray = Arrays.copyOfRange(nums, 0, topIndex); ;
            int[] rightArray = Arrays.copyOfRange(nums, topIndex + 1, nums.length);
            TreeNode root = new TreeNode(nums[topIndex]);
            root.left = sortedArrayToBST(leftArray);
            root.right = sortedArrayToBST(rightArray);
            return root;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
