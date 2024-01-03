"""
Algorithm: Dynamic Programming

Sub-problem: f(i,j), the number of ways we can move to point grid[i][j]
base case: f(0,X) = 1
           f(X,0) = 1
           X here can be any value
Reurrence relation: f(i,j) = f(i-1,j) + f(i,j-1)

To conserve space: only hold the last 2 rows of information, the rows before this would not longer be needed in new calculations

TC: O(nm) SC: O(n)
"""

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1 for i in range(n)] for j in range(2)] # initalize dp table with 1's to take care of base case
        for i in range(1,m):
            for j in range(1,n):
                dp[1][j] = dp[0][j] + dp[1][j-1]
                dp[0] = dp[1]
        return dp[1][n-1]
