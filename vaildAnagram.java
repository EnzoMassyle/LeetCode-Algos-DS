/**
Prompt: Given two strings s and t, return true if t is an anagram of s, and false otherwise.

High Level Solution: 
1. Two pass TC O(N), SC O(N);
    - Create two Maps to keep track of the characters in both strings and their frequencies
    - Add characters and frequencies to respective lists
    - Check if each Map contains the sames characters and the same frequencies

2. One pass TC O(N), SC O(1) (optimal):
    - Create array of size 26, with each index representing the the ith letter in the alphabet
    - iterate through both strings:
        - for string s: increment the frequency of current letter
        - for string t: decrement the frequency of the current letter
    - Check that the frequencies for all letters in the alphabet are 0
 */



class Solution {
    public boolean isAnagram(String s, String t) {

        // If the stings differ in length, they cannot be an anagram
        if (s.length() != t.length()) return false;

        // one pass (Optimal)

        int[] letters = new int[26];
        final int CHAR_OFFSET = 97;

        for (int i = 0; i < s.length(); i++) {
            int curS = (int) s.charAt(i) - CHAR_OFFSET;
            int curT = (int) t.charAt(i) - CHAR_OFFSET;

            letters[curS] += 1;
            letters[curT] -= 1;
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) return false; 
        }
        return true;
    }



        // two pass

        // Map<Character, Integer> letterCountS = new HashMap<>();
        // Map<Character, Integer> letterCountT = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char curS = s.charAt(i);
        //     char curT = t.charAt(i);
        //     if (letterCountS.containsKey(curS)) letterCountS.put(curS, letterCountS.get(curS) + 1);
        //     else letterCountS.put(curS, 1);
        //     if (letterCountT.containsKey(curT)) letterCountT.put(curT, letterCountT.get(curT) + 1);
        //     else letterCountT.put(curT, 1);
        // }

        // for (Character letter : letterCountS.keySet()) {
        //     if (!letterCountT.containsKey(letter) || !letterCountT.get(letter).equals(letterCountS.get(letter))) return false;
        // }
        // return true;
}
