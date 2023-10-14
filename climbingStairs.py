
'''
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Dynamic programming algo: 
    subproblem, dp[i]: the number of ways to reach step i
    recurrence: dp[i] = dp[i-1] + dp[i-2]. Taking two steps to reach i or one step to reach i
    base case: dp[0] = 1: there is one way to not take any steps
               dp[1] = 1: taking one step is the only way to get to step 1

TC: O(N), SC: O(N), 

Note we can do this with O(1) space, it is performed below as well

'''

class Solution:
    def climbStairs(self, n: int) -> int:

        # Create dp array
        dp = [0] * (n+1)

        #initialize base cases:
        dp[0] = 1
        dp[1] = 1

        # bottom-up dp 
        for i in range (2, n+1):
            dp[i] = dp[i-1] + dp[i-2]

        return total

# If you want to use no extra space, not really necessary since n <= 45, but if this were not the case this solution is much more efficient space wise.
        # oneStep = 1
        # twoStep = 1
        # total = 1

        # for i in range(2, n+1):
        #     total = oneStep + twoStep
        #     twoStep = oneStep
        #     oneStep = total
        # return total
        
