'''
Prompt: Given an integer array nums, find the subarray with the largest sum, and return its sum.

High level Sol
    DP algorithm: 
        - subproblem: curSubArrSum: the sum of the current sub array we are considering
        - recurrence: determine the current sub array sum by taking the max over the current element in the array and the sum of the current subseqence and the current element. Whichever one is bigger the the current sub array
        - base case: the best subarray to start with be a sub-array with just the first element
    
TC: O(N), SC: O(1)
'''

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:

        maxSum = curSubArrSum = nums[0]

        for i in range(1, len(nums)):
            curSubArrSum = max(nums[i], curSubArrSum + nums[i])
            maxSum = max(maxSum, curSubArrSum)

        return maxSum
