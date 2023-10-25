'''
prompt: Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0


High level Solution:
- Use dynamic programming: 
    > sub-problem, what is the longest common subsequence using up to i characters in text1 and j characters in text2
    > recurrence relation: dp(i,j) = (1) dp(i-1,j), (2) dp(i,j-1), (3) dp(i-1,j-1) + 1 (if current chars are the same, otherwise 0)
        * (1) LCS with using i-1 chars in text1 and j chars in text2
        * (2) LCS with using i chars in text1 and j chars in text2
        * (3) LCS with using i-1 chars in text 1 and j-1 chars in text2 include the current char if they are equal in both strings
    > fill dp table row by row left to right
    > return bottom right entry in dp table

TC: O(nm), SC: O(nm)
'''

from math import inf
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        def diff(x,y):
            if x == y: return 1
            return 0

        n = len(text1)
        m = len(text2)

        if n == 0 or m == 0:
            return 0

        dp = [[0 for i in  range(m+1)] for j in range(n+1)]

        for i in range(1, n+1):
            for j in range(1, m+1):
                dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] + diff(text1[i-1], text2[j-1]))
        
        return dp[n][m]
        
