/**
prompt: A self-dividing number is a number that is divisible by every digit it contains.
For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
A self-dividing number is not allowed to contain the digit zero.
Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].

High-Level Solution: 
    - Loop through the range [left, right]
    - check if each number in this range is self-divding, if so, append to list


TC: O(N * M)
SC: O(M)
where M is the length of the integer right
 */


class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDividingNums = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) selfDividingNums.add(i);
        }
        return selfDividingNums;
    }
    public boolean isSelfDividing(int n) {
        int modifiedN = n;
        while (modifiedN / 10.0 > 0) {
            int curDigit = modifiedN % 10;
            if (curDigit == 0 || n % curDigit != 0) return false;
            modifiedN /= 10;
        }
        return true;
    }
}
