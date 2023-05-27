/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
Prompt: Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

High level solution: 
    Set method: TC O(N),SC O(N)
    - create set to hold nodes from linked list
    - add each node from the linked list to the set
    - if the current node already exists in the set, there is a cycle

    Two pointer method: TC O(N), SC O(1)
    - Have two pointers, one fast point and one slow pointer
    - If there is a cycle in the list, the fast pointer will catch up to the slow pointer 
    - If either pointer becomes null, we know a cycle doesn't exist
 */

public class Solution {
    public boolean hasCycle(ListNode head) {

        /* Set method
        Set<ListNode> nodes = new HashSet<>(); // create set representing each node
        ListNode curr = head;
        while (curr != null && !nodes.contains(curr)) { // stop if either we reach the end of the linked list or find a cycle
            nodes.add(curr);
            curr = curr.next;
        }
        if (curr != null) return true;
        else return false; */

        // two pointer method
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null) {
            fast = fast.next;
            if (isSame(fast, slow)) return true;
            slow = slow.next;
            if (fast != null) fast = fast.next;
            if (isSame(fast, slow)) return true;
        }
        return false;
        
    }

    public boolean isSame(ListNode p, ListNode q) {
        return p != null && q != null && p == q;
    }
}
