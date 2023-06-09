/**
Prompt: You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.


High Level Sol: 
    - initialize the initial greatest letter and initalial difference between this and the target
    - loop over the rest of letters, updating the smallest letter greater than target

TC: O(N), SC: O(1)
 */


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char smallestLetter = letters[0];
        int minDif;
        if (letters[0] - target > 0) minDif = letters[0] - target;
        else minDif = 999;
        for (int i = 1; i < letters.length; i++) {
            int curDif = letters[i] - target;
            if (curDif > 0 && curDif < minDif) {
                minDif = curDif;
                smallestLetter = letters[i];
            }
        }
        return smallestLetter;
    }
}
