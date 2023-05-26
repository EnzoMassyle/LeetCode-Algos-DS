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
 Prompt: Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 High level Solution:
    1. Split tree down middle
    2. check equality (left value == right value)
        - if any two nodes are not equal, stop traversing

TC: Best Case 0(1), Worst Case 0(N)
SC: Best Case 0(1), Worst Case 0(N)
  */


class Solution {
    public boolean isSymmetric(TreeNode root) {
        return traverse(root.left, root.right);
    }
    public boolean traverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return true && 
            traverse(left.left, right.right) && 
            traverse(left.right, right.left);
        }

    }
}
