/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



 /**
 Prompt: Given a binary tree, determine if it is height-balanced

 High level Sol:
    1. Calculate the height of the left and right sub-tree
    2. if at any point the tree becomes un-balanced, stop recursion

TC: O(N)
SC: O(N)
.
  */
class Solution {
    public boolean isBalanced(TreeNode root) {
        int rootHeight = calcHeight(root);
        return rootHeight != -1;
    }

    private int calcHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) 
        {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
