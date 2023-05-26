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
Prompt: Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.

High Level Sol: 
    1. Calculate the midpoint of array
    2. Assign the left and right of bst using recursion
        > value of left Node will be the midpoint of the left half of list
        > value of right Node will be the midpoint of the right half of list

TC: O(N), SC: O(N)
    */
class Solution {

    

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length <= 0) {
            return null;
        } else {
            TreeNode bst = new TreeNode();
            int mid = nums.length / 2;
            bst.val = nums[mid];

            bst.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
            bst.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

            return bst;
        }

    }

}
