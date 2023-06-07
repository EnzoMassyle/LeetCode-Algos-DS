/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /**
 prompt: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

 High Level Sol :
    - Using A set: TC O(N + M), SC (N + M)
        1. traverse through each SLL, storing their nodes in a set
        2. If we encounter a node in either list that already exists in the set, we have found the node of intersection
        3. If we reach the end of both lists, then there are no nodes of intersection, return null
    - Optimal Solution: TC O(N + M), SC O(1)
        1. Continuously traverse through each list until we reach a node of intersection
            - Have two pointers, one for listA one for listB (ptrA, ptrB)
            - once ptrA has reached the end of listA, begin traversing listB
            - once ptrB has reached the end of listB, begin traversing listA
        2. when the two pointers are equal, return either pointer
  */
public class Solution {
    //private Set<ListNode> nodesSeen = new HashSet<>();
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /* Set Solution
        if (headA != null) {
            if (nodesSeen.contains(headA)) return headA;
            else nodesSeen.add(headA);
        }
        if (headB != null) {
            if (nodesSeen.contains(headB)) return headB;
            else nodesSeen.add(headB);
        }

        if (headA != null && headB != null) return getIntersectionNode(headA.next, headB.next);
        else if (headA == null && headB != null) return getIntersectionNode(headA, headB.next);
        else if (headA != null && headB == null) return getIntersectionNode(headA.next, headB);
        else return null;*/


        // Optimal Solution

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while (ptrA != ptrB) {
            if (ptrA == null) ptrA = headB;
            else ptrA = ptrA.next;

            if (ptrB == null) ptrB = headA;
            else ptrB = ptrB.next;
        }

        return ptrA;



    }
}
