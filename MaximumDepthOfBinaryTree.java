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
 Prompt: Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. 

High Level Solution: 
    1. initialize tracker for maximum Depth
    2. Traverse through tree
    3. return maximum Depth found

TC: 0(N)
SC: 0(N)
*/

class Solution {
    private int md = 0;
    public int maxDepth(TreeNode root) {
        findMaxDepth(root, 1);
        return md;
    }

    public void findMaxDepth(TreeNode root, int currDepth) {
        if (root != null) {
            md = Math.max(md, currDepth);
            findMaxDepth(root.left, currDepth + 1);
            findMaxDepth(root.right, currDepth + 1);
        }
    }
}
