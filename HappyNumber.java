/**
Prompt: Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.

High Level Solution: 
    - Use a set to store already seen versions of n when the digits are the sum of the squared
    - calculate the sum of squares for each n and add to set. stop when we reach n == 1 or n already exists in set
    - return true or false depending on the value of n
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumSquared(n);
        }
        if (n == 1) return true;
        else return false;  
    }
    private int getSumSquared(int n) {
        int sumSquared = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sumSquared += lastDigit * lastDigit;
            n /= 10;
        }
        return sumSquared;
    }
}
