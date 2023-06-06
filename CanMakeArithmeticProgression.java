/**
Prompt: A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.


High Level Sol: 
    - Sort input array
    - given arr.length >= 2, calculate the difference between the first 2 elements in array
    - for rest of the array, check the difference remains constant, if not return false

TC: O(NLogN)
SC: O(1)
 */
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[0] - arr[1];

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i+1] != difference) return false;
        }

        return true;
    }
}
