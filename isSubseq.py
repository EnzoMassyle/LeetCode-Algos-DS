'''
Prompt: Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

High lvl sol:
    - Full scan TC: O(N), SC: O(1)
        > Scan through t and each time we reach a character that is the first character in s, pop off first char in s
        > if at any point s is an empty string return true else it's false
    - Two pointer TC: O(N), SC: O(1) (More efficient)
        > provide two pointers for both s and t
        > scan t the following way, there are three cases:
            1. both pointers of t point to the same thing and correspond to a char in s
                > increment either l_s or r_s but not both due to overcounting
            2. char of left pointer t equals char of left pointer s
                > increment l_s by 1
            3. char of right pointer t equals char of right pointer s
                > decrement r_s by 1
            Always move in the pointer of t each iteration: (decrement r_t and increment l_t)
        > at the end if the pointer l_s crossed r_s that means we s is a subseq of t
'''
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:

        # single scan
        # for c in t:
        #     if s != "":
        #         if c == s[0]: s = s[1:]
        #     else: return True
        # return s == ""


        # Two pointer
        l_t = 0
        r_t = len(t) - 1

        l_s = 0
        r_s = len(s) - 1

        while l_s <= r_s and l_t <= r_t:
            if l_t == r_t and t[l_t] == s[l_s] and t[r_t] == s[r_s]:
                l_s += 1
            else:
                if t[l_t] == s[l_s]: l_s += 1
                if t[r_t] == s[r_s]: r_s -= 1
            l_t += 1
            r_t -= 1
        return l_s > r_s



        
