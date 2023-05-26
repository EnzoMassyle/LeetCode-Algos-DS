/**
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

High level sol: 
    - Create 2D array representing pascals triangle, initialize first row
    - For each row after:
        1. insert first entry with 1
        2. insert entries [2, i - 1] using row above
        3. insert last entry with 1
    - Iterate until numRows is reached

TC: O(N^2)
SC: O(N^2) 

 */


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt = new ArrayList<>();
        pt.add(Arrays.asList(1));
        //rec(numRows, 2);

        for(int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for (int j = 1 ; j < i; j++) {
                curRow.add(pt.get(i-1).get(j-1) + pt.get(i-1).get(j));
            }   
            curRow.add(1);
            pt.add(curRow);
        }
        return pt;
    }
}
