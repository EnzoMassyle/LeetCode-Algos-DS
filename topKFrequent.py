'''
Prompt: Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

High level sol:
    - create dictionary {element:frequency}
    - sort dictionary in descending order based on frequency
    - add the first k elements to a list

SC: O(N)
TC: O(NlogN)
'''



class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = {}

        for el in nums:
            if el not in freqs:
                freqs[el] = 1
            else:
                freqs[el] += 1
        
        sorted_items = sorted(freqs.items(), reverse  = True, key = lambda x: x[1])
        print(sorted_items)
        k_most_freq = []

        for i in range(k):
            k_most_freq.append(sorted_items[i][0])
        return k_most_freq

