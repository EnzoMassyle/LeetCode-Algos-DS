'''
Prompt: Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order. 

High Level Solution: 
    - Break problem down until we are left with the empty list (Base case)
    - With each current permutation list, we are guaranteed that we have all the permuations of a subset of the list.
    Now we just add the new element in every possible position, yielding all possible permutations.

TC: O(n! * n) 
    - The number of permutations is n!
    - It requires n work to assemble each permutation
'''

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums: 
            return [[]]
        curr_perm = self.permute(nums[1:])
        permutLst = []
        for perm in curr_perm:
            for i in range(len(nums)):
                permutLst += [perm[:i] + [nums[0]] + perm[i:]]
        return permutLst
