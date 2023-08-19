/**
Prompt: Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


High Level Solution: 
    1. Create a HashMap that does the following: 
        - each key is a sorted version of word in list
        - the values are list of words that are anagrams of the key
    2. for each word in strs:
        - sort the word as the key
        - if the key already exists append the word in the map
        - if it doesn't, create a new entry
    

 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (anagramMap.containsKey(sortedWord)) anagramMap.get(sortedWord).add(word);
            else {
                List<String> anagrams = new LinkedList<>();
                anagrams.add(word);
                anagramMap.put(sortedWord, anagrams);
            }
        }
        return new ArrayList<>(anagramMap.values());
    }
}
