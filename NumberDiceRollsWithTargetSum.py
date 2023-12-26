# DP: 
# Sub-problem: f(i,j) the number of ways we can sum to j using i dice
# base case: f(0,0) = 1, the number of ways to sum to 0 using no dice
# Recurrence relation: f(i,j) = sum(dp[i-1][j-t] for all t that is less than min(k, j))

# TC: O(n*m*k), m = target, SC = O(n*m*k)

class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        MOD = 10 ** 9 + 7
        dp = [[0 for i in range(target + 1)] for j in range(n + 1)]
        dp[0][0] = 1 # Base case

        for i in range(1, n + 1): # go through the number of dice
            for j in range(1, target + 1): # the target we are trying to reach
                dp[i][j] = sum([dp[i-1][j-t] for t in range(1, min(k,j) + 1)])
        return dp[n][target] % MOD
