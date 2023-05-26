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
 Prompt: Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

High Level Sol. 
    1. Traverse both trees, Pre-order will be the most efficient
    2. Check equality at each node, if any two nodes are not equal, stop traversing

TC: Best Case: 0(1), Worst Case: 0(N)
SC: Best Case: 0(1), Worst Case: 0(N)
  */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Base case: check nullity
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        // Preorder Traversal
        } else if (p.val != q.val) {  //visit Node
            return false;
        } else {
            return true && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // Traverse
        }
    }
}
