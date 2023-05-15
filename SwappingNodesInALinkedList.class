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
Prompt: You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).


High level Solution:

    1. Get the size of a list
    2. Get the values at the Kth node from the beginning and the Kth node from the end
    3. Swap values 


TC: O(N)
SC: O(1)

 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        Deque<Integer> valuesAtK = new ArrayDeque<>();
        int size = 1; // do this since 1-indexed

        // Get size
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // get values at k

        curr = head;
        int i = 1;
        while (curr != null) {
            if (i == k) {
                valuesAtK.addFirst(curr.val);
            } else if (i == size - k) {
                valuesAtK.addLast(curr.val);
            }

            i++;
            curr = curr.next;
        }


        //swap values

        curr = head;
        i = 1;
        while (curr != null) {
            if (i == k) {
                curr.val = valuesAtK.getLast();
            } else if (i == size - k) {
                curr.val = valuesAtK.getFirst();
            }
            i++;
            curr = curr.next;  
        }


        return head;
        
    }
}
