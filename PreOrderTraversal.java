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
 prompt: Given the root of a binary tree, return the preorder traversal of its nodes' values.

 Recursive Solution:
    1. add current node's value to list
    2. Recurse on the left node first, then the right node

 Iterative Solution: 
    1. Initalize stack with root of Tree
    2. while the stack is not empty:
        - pop current node off the stack
        - add its value to list
        - push children into the stack in this order
            1. right child
            2. left child
  */
class Solution {
    private List<Integer> preOrder = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        // recursive solution 
        recHelper(root);
        return preOrder;
        //
        

        //iterative solution
        Stack<TreeNode> s = new Stack<>();
        if (root != null) s.push(root);
        while(!s.empty()) {
            TreeNode node = s.pop();
            preOrder.add(node.val);
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
        }
        return preOrder;
        //
    }

    private void recHelper(TreeNode root) {
        if (root != null) {
            preOrder.add(root.val);
            recHelper(root.left);
            recHelper(root.right);
        }
    }
}
