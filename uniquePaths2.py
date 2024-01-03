'''
prompt: You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.


Sub-problem: f(i,j) = the number of ways to get to spot (i,j) on the grid
Recurrence relation: f(i,j) = f(i-1, j) + f(i,j-1) if the spot is not an obstacle.
                     f(i,j) = 0 if spot is an obstacle
base case: f(0,X) = 0 if any column 0 , ... , X-1 has an obstacle. else 1
           f(X,0) = 0 if any row 0 , ...  , X-1 has an obstacle. else 1

TC: O(nm) = SC: O(nm)

'''

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[0 for i in range(n)] for j in range(2)]
        
        # BASE CASES   
        obstacleSeen = False
        for i in range(n):
            if obstacleGrid[0][i] == 1:
                break
            else: dp[0][i] = 1
        
        if m == 1:
            return dp[0][n-1]
        
        for i in range(1,m):

            if dp[0][0] == 0 or obstacleGrid[i][0] == 1:
                dp[1][0] = 0
            else: 
                dp[1][0] = 1

            for j in range(1,n):
                if obstacleGrid[i][j] == 1:
                    dp[1][j] = 0
                else:
                    dp[1][j] = dp[0][j] + dp[1][j-1]
            dp[0] = dp[1]


        return dp[1][n-1]

            
        
