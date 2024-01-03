'''
Sub-problem f(i,j), the mininum sum that ends at triangle[i][j]
Recurrence relation, f(i,j) = min(f(i-1,j-1), f(i-1,j)) + trangle[i][j]
Base case:  f(0,0) = triangle[0][0]
            f(i,0) = f(i-1,0) + triangle[i][0]

TC: O(bh), SC: O(bh) b = base , h = height    
'''

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        rows = len(triangle)
        dp = [[0 for i in range(j+1)] for j in range(rows)]

        print(dp)

        # Base Case: 
        dp[0][0] = triangle[0][0]

        for r in range(1,rows):
            for c in range(r + 1):
                el = triangle[r][c]
                if c == 0:
                    dp[r][c] = dp[r-1][0] + el
                elif c == r:
                    dp[r][c] = dp[r-1][r-1] + el
                else:
                    dp[r][c] = min(dp[r-1][c-1], dp[r-1][c]) + el
                    
        return min(dp[rows-1])

        
