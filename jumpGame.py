'''
prompt: You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Dynamic Programming Algorithm: TC O(n^2), SC O(n)
Sub-problem: f(i): the farthest point one can reach using position at index i
Recurrence relation: f(i) = i + nums[i]
                     if no j exists st f(j) >= i return false 
                     If end of loop is reached or at any point position i makes it to the end of the array, return true
Base case: f(0) = nums[0]

'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [0] * n

        # BASE CASE
        if nums[0] >= n-1: return True # End is reachable from position 0
        dp[0] = nums[0]

        for i in range(1,n):
            positionReachable = False
            for j in range(i-1,-1,-1): # Find if position i is reachable from any of the positions j < i
                if dp[j] >= i:
                    positionReachable = True
                    break
            if not positionReachable: # We cannot make it to the end of the array
                return False
            else:
                dp[i] = i + nums[i] 
                if dp[i] >= n-1: # We can make it to the end of the array from position i
                    return True

        return True # indicates end of the array is reached



        
