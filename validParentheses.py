'''
    - Valid Parentheses - 

    given a string with just characters: '(', ')', '{', '}', '[' and ']'
    determine if the input string is valid (that is every open parenthese has a
    corresponding closing parenthese)

    Time Complexity: O(N)
    Space Complexity: O(N)
'''

def isValid(s):
    currentOpen = []
    closedParens = {')': '(', '}': '{', ']': '['}

    for paren in s:
        if paren in closedParens.values():
            currentOpen += paren
        elif (len(currentOpen) == 0 and paren in closedParens) or closedParens[paren] != currentOpen[-1]:
            return False
        else:
            currentOpen.pop()
    return len(currentOpen) == 0