/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
Prompt: Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.


High Level Sol: 
    - remove all elements from beginning of linked list that begin with target value
    - For the rest of the list:
        1. keep track of the previous and current node 
        2. every time we encounter the target value, remove it by reassigning the prev next pointer 
    - return new head of list

TC: O(N), SC: O(1)

 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) { // skip all elements in beginning that begin with target value
            head = head.next;
        }
        if (head == null) return null;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) { // remove elements in linked list with target value
            if (cur.val == val) prev.next = cur.next;
            else prev = prev.next;
            cur = cur.next;
        } 
        return head;
    }
}
