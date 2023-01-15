'''
    - Add Two Numbers - 
    Given two non-empty linked lists that represent
    two non-negative integers with each node representing a single digit,
    add the two numbers and return the sum as a linked list


    Time Complexity: O(max(m, n))
    Space Complexity: O(max(m, n))



    Base Case - Both lists are empty and carry = 0
        - there is nothing left to do so return None
    Recursive case:

    if both list are non-empty:
        - add together, l1.val, l2.val and carry
        - use ListNode constructor to form a new Node with its value 
        being the first digit in the sum and next being a recursive call with carry updated to the second digit in sum
    if one list is non-empty:
        - perform addition with the non-empy list and carry
        - use ListNode constructor to form a new Node with its value 
        being the first digit in the sum and next being a recursive call with carry updated to the second digit in sum
    if both lists are empty but carry is not zero:
        - Use ListNode constructor for form new node with carry being the value and the next being a recursive call with carry being
        updated to zero
    
'''
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1, l2):
    def rec(l1, l2, carry):
        if l1 is None and l2 is None:
            if carry == 0:
                return None
            else:
                return ListNode(carry, rec(l1, l2, 0))
        elif l2 is None:
            summation = l1.val + carry
            return ListNode(summation % 10, rec(l1.next, l2, summation // 10))
        elif l1 is None:
            summation = l2.val + carry
            return ListNode(summation % 10, rec(l1, l2.next, summation // 10))
        else:
            summation = l1.val + l2.val + carry
            return ListNode(summation % 10, rec(l1.next, l2.next, summation // 10))
    return rec(l1, l2, 0)

