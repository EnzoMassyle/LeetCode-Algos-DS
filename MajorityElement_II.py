'''
Prompt: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

High level sol: 
- sort array
- iterate through the list and do the following
    > if the element has appeared more than n/3 times in a row, add to set
    > if the next element is the same as before, put a note that we have seen this element again
    > if this is the first time we have seen this element reset the counter to 1 to mark the first time we have seen this element
TC: O(NlogN) SC:O(1) no extra space besides the set that must be returned
'''


class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        # Sort list
        nums.sort()

        #Get length of list
        n = len(nums)


        # For an element, if there are more than n/3 of them in a row than that is a majority element
        majority_elements = set()
        curr_el_majority = 1
        i = 0
        # iterate through list
        while i < n:
            # If the element has appeared more that n/3 times in a row add it to set
            if curr_el_majority > n // 3:
                majority_elements.add(nums[i])
            # Next element is the same as before
            if i + 1 < n and nums[i] == nums[i+1]:
                curr_el_majority += 1
            # Seen element for the first time in list
            else:
                curr_el_majority = 1
            i += 1

        return majority_elements

        
