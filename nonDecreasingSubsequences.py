
'''
    - Non-Decreasing Subsquences -

    for a integer array (nums) return all sequences where the all the different
    possible subsequences are in non-decreasing order with at least 2 array elements


    Time complexity: O(2^N)
    Space complexity: O(2^N), if we only do not count the ans as part of space complexity then it is O(N) for the recursive call stack

'''


def findSubsequences(nums):
    result = set() # use a set to account for duplicates
    seq = []

    def backtrack(index):
        if index == len(nums): # we have reached the checked all elements in list
            if len(seq) >= 2: # we only care about sequences with at least two elements
                result.add(tuple(seq))
            return
        else:
            if not seq or seq[-1] <= nums[index]: # if the list is empty or the last element of sequence is less that nums are our current index
                seq.append(nums[index])
                backtrack(index + 1)
                seq.pop()
            backtrack(index + 1)
    
    backtrack(0)
    return result
