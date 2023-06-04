class Solution {

    /** prompt: Given an array nums of size n, return the majority element.The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    High level sol: 
        - Create map and fill wil each element in nums and the amount of times it occurs in the array
        - search for element that occurs more than n / 2 times

    TC: O(N)
    SC: O(N)
     */


    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numOccurences = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numOccurences.containsKey(nums[i])) {
                numOccurences.put(nums[i], 1);
            } else {
                numOccurences.put(nums[i], numOccurences.get(nums[i]) + 1);
            }
        }

        for (int key : numOccurences.keySet()) {
            if (numOccurences.get(key) > nums.length / 2) {
                return key;
            }
        }

        return -1;
        
    }
}
