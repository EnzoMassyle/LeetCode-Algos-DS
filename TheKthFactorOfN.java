
/**

prompt: You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.


High Level Sol: 
    - Using a List: TC O(N), SC O(N)?
        1. Add all factors to list
        2. if numFactors < k return the (k-1)th elemtent in the list of factors
    
    - No Data Structure: TC O(N), SC O(1)
        1. keep track of number of factors
        2. If we reach the kth factor, return it
        3. account for the edge case where the k == numFactors + 1, in this case, the factor is n
        4. return -1 for the case that k > numFactors + 1
 */


class Solution {
    private List<Integer> factors = new ArrayList<>();
    public int kthFactor(int n, int k) {

        /*
        for (int divisor = 1; divisor <= n / 2; divisor++) {
            if (n % divisor == 0) factors.add(divisor);
        }
        factors.add(n);

        if (factors.size() < k) return -1;
        else return factors.get(k - 1);
        
        */
        //  No DS Solution

        int numFactors = 0; // 1 and n will be factors of n
        for (int divisor = 1; divisor <= n / 2; divisor++) {
            if (n % divisor  == 0) {
                numFactors++;
            }
            if (numFactors == k) {
                return divisor;
            }
        }
        if (numFactors + 1 == k) return n;
        else return -1;
    }
}
