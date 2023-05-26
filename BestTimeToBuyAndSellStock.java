/**
Prompt: You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


High level Sol: 

    Naive Sol: O(N^2)
     - At each element, calculate difference with every other element
     - return maximum difference

    Optimal Solution: O(N)
    - Keep track of two things
        1. Minimum price
        2. Maximum profit
    - find Maximum profit by subtracting the current price from the minimum price
    - return maximum profit


 */

class Solution {
    public int maxProfit(int[] prices) {

        // // naive solution
        // int dif = 0;

        // for (int i = 0; i < prices.length; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         dif = Math.max(dif, prices[j] - prices[i]);
        //     }
        // }
        // return dif;


        // one pass solution

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);

        }

        return maxProfit;    
    }
}
