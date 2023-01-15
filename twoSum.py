
'''
    - Two Sum - 

    Given an array of integers and a integer target
    return the indices of the two numbers such that
    they add up to the target. You cannot use the 
    same element twice

'''

''' 
    Method 1 - Brute force
        Time Complexity: O(N^2)
        Space Complexity: O(1)

        for each element in the array, check all other elements to see if their sum adds to target
'''
def twoSum_methodOne(nums, target):
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]
    
'''
    Method 2 - Two Pass Hash Table
        Time Complexity: O(N)
        Space Complexity: O(N)

        Make two passes:
        
        pass one will gather each value as the key and their corresponding index as the value

        pass two will look at the complement of each value in nums 
        (ex: 4 = 6 - x, what is x? x is the complement which is 2)
        if the complement exists in the keys of the dictionary, then
        we have found our two indices that will add to the target value

'''
def twoSum_methodTwo(nums, target):
    hashTable = {}

    for i in range(len(nums)):
        hashTable[nums[i]] = i
    
    for i in range(len(nums)):
        complement = target - nums[i]
        if complement in hashTable and hashTable[complement] != i: # Need to make sure that if the complement exists in the hashtable that it is not at the same index
            return [hashTable[complement], i] 
            

'''
    Method 3 - One Pass Hash Table
        Time Complexity: O(N)
        Space Complexity: O(N)

    In this method we only make one pass:
    first check if the complement exists in our hash table 
    and if it does then we have found our match. If it does
    not exist then we had nums at index i to the hash table 
    with its value being the index
'''

def twoSum_methodThree(nums, target):
    hashTable = {}

    for i in range(len(nums)):
        complement = target - nums[i]
        if complement in hashTable:
            return [i, hashTable[complement]]
        hashTable[nums[i]] = i