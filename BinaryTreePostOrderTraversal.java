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
 Prompt: Given the root of a binary tree, return the postorder traversal of its nodes' values.

 High Level Sol: 
    - Recurse left child
    - Recurse right child
    - add current node's value to List

TC: O(N)
SC: O(N)

  */
class Solution {
    private List<Integer> postOrder = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        recHelper(root);
        return postOrder;
        
    }

    public void recHelper(TreeNode root) {
        if (root != null) {
            recHelper(root.left);
            recHelper(root.right);
            postOrder.add(root.val);
        }
    }
}
