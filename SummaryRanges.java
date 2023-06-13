/**
Prompt: You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

High Level Solution:
    - Have two variables representing the current range of interest
    - While there are consecutive integers, extend the range
    - When an integer is encountered that is not consecutive, append the range recorded to the list of ranges

TC: O(N), SC: O(N)
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new LinkedList<>();
        if (nums.length == 0) return ranges;
        int startRange = nums[0];
        int endRange = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] - nums[i] == 1) {
                endRange++;
            } else {
                if (startRange == endRange) ranges.add(Integer.toString(startRange));
                else ranges.add(Integer.toString(startRange) + "->" + Integer.toString(endRange));
                startRange = nums[i+1];
                endRange = nums[i+1];
            }   
        }
        if (startRange == endRange) ranges.add(Integer.toString(startRange));
        else ranges.add(Integer.toString(startRange) + "->" + Integer.toString(endRange));
        return ranges;
    }
}
