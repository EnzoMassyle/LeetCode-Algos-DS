/**
Prompt: You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.


High Level Sol: 
    - Check edge case where there are no characters where it is > target
    - Given letters is sorted in non-decreasing order, perform a binary search to find smallest character

TC: O(LogN), SC: O(1)
 */


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        if (letters[letters.length - 1] <= target) return letters[0]; // there are no elements in letters > target
        
        int start = 0;
        int end = letters.length - 1;
        int mid = (end + start) / 2;
        int minDif = 999;
        char greatestLetter = letters[mid];

        while (start <= end) {
            int curDif = letters[mid] - target;
            if (curDif <= 0) start = mid + 1;
            else if (curDif < minDif)  {
                greatestLetter = letters[mid];
                end = mid - 1;
            }
            mid = (end + start) / 2;
        }

        return greatestLetter;
    }
}
