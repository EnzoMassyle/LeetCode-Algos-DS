
'''
    - Merge Two Sorted Lists -

    Given two sorted linked lists, merge the two lists into 
    one sorted list and return the head of the merged linked list

'''


''' 
     - Recursive approach

    Time complexity: O(N + M)
    Space complexity: O(N + M)
'''
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val   

        self.next = next
def mergeTwoLists(list1, list2):
    if list1 is None:
        return list2
    elif list2 is None:
        return list1
    if list2.val > list1.val:
        return ListNode(list1.val, mergeTwoLists(list1.next, list2))
    else:
        return ListNode(list2.val, mergeTwoLists(list1, list2.next))