'''
Prompt: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.


High level sol:
    - sort array
    - for each element in the array, perform a two pointer scan on the rest of the array
    - For each three sum: 
        > if sum < 0, increment left pointer (i.e try to increase the sum)
        > if sum > 0, decrement right pointer (i.e try to decrease the sum)
        > if sum == 0, we have found a triplet, add to hashset
    - Also in the scan using two pointers, note that l cannot equal r, since using duplicate indicies are not allowed
    
SC: O(N)
TC: O(N^2)
'''


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        triplets = set()
        length = len(nums)
        for i in range(length-2):
            l = i+1
            r = length - 1
            while l < r:
                triplet = nums[i] + nums[l] + nums[r]
                if triplet == 0:
                    triplets.add((nums[i],nums[l],nums[r]))
                    l += 1
                    r -= 1
                elif triplet < 0: 
                    l += 1
                else: r -=1

        return triplets

        
