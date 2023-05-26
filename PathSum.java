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
 Prompt: Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

High level Sol: 
    - Traverse down the tree, keeping track of the current sum
    - If we find a root-to-leaf path where we reach the target sum, we are done 
    - If target sum is not reached, the whole tree will be traversed and we will return false;

TC: O(N)
SC: O(N)

  */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return rec(root, targetSum, 0);
    }
    private boolean rec(TreeNode root, int targetSum, int curSum) {
        if(root == null) return false;
        if (root.left == null && root.right == null && curSum + root.val == targetSum) return true;
        return rec(root.left, targetSum, curSum + root.val) || rec(root.right, targetSum, curSum + root.val);
    }
}
