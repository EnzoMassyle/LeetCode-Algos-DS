'''
Prompt: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Dynamic Programming algorithm: 

Sub-problem: f(i) maximum money with using only the first i houses
Recurrence relation: f(i) = max(nums[i] + f(i-2), f(i-1)). at each step, we either choose to rob the house or we don't 
Base Case: f(0) = nums[0], f(1) = max(nums[0], nums[1])

TC: O(N), SC: O(1) <- only need to keep track of the previous 2 sub-problems, can do this with tracker variables using constant space

'''

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]

        prevPrevHouse = nums[0]
        prevHouse = max(nums[0], nums[1])
        maxMoney = max(prevPrevHouse,prevHouse)
        
        for i in range(2, n):
            maxMoney = max(nums[i] + prevPrevHouse, prevHouse)
            prevPrevHouse = prevHouse
            prevHouse = maxMoney
        return maxMoney
        
        
        
