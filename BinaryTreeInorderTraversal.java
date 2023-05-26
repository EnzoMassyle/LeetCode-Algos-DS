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

 Prompt: Given the root of a binary tree, return the inorder traversal of its nodes' values.

 High Level Sol:
    1. Make DS to formulate solution
    2. Perform inOrder Traversal
        - traverse left child
        - visit 
        - traverse right child

TC: 0(N) - Visits every node once 
SC: Bushy Tree 0(Log(N)), Spindly Tree 0(N) - space complexity depends on the tree height
  */

class Solution {
    List<Integer> inOrderList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        putTraversalToList(root);
        return inOrderList;

    }

    public void putTraversalToList(TreeNode root){
        if (root != null) {
            putTraversalToList(root.left);
            inOrderList.add(root.val);
            putTraversalToList(root.right);
        }
    }
}
