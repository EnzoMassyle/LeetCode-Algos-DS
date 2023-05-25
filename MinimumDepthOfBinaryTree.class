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
 Prompt: Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


High level Sol: 
    - Create a list to hold the depths of each leaf
    - traverse through the tree, keeping track of the current depth
    - when a leaf is reached, add current depth to the list 
    - After traversal, return the smallest value in the list, this represents the   shortest path from the root to a leaf. 

TC: O(N)
SC: O(N + numberOfLeaves) ≈ O(N)
  */
class Solution {
    private List<Integer> leafDepths = new ArrayList<>();
    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        rec(root, 1);
        return Collections.min(leafDepths);
    }

    public void rec(TreeNode root, int curDepth) {
        if(root != null) {
            if (root.left == null && root.right == null) {
                leafDepths.add(curDepth);
            }
            rec(root.left, curDepth + 1);
            rec(root.right, curDepth + 1);
        }
    }
}
