
/**
Prompt: There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

High Level Solution: 
1. Using Array: TC O(N) SC O(N)
    - create new array to represent altitudes, fill using gain array
    - find max in altitudes array and return
2. In-Place: TC O(N) SC O(1)
    - Create two tracker variables, one to represent current altitude and one to represent the max
    - Loop through array of gains and update current altiude and max altitude and return

 
 */

class Solution {
    public int largestAltitude(int[] gain) {
        // Solution using data strucure:
        // int[] altitudes = new int[gain.length + 2];
        // altitudes[0] = 0;
        // for (int i = 1; i <= gain.length; i++) altitudes[i] = gain[i-1] + altitudes[i-1];
        // int max = altitudes[0];
        // for (int i = 1; i < altitudes.length; i++) {
        //     if (altitudes[i] > max) max = altitudes[i];
        // }
        // return max;

        // in place solution: 
        int currentAltitude = 0;
        int highestAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            if (currentAltitude > highestAltitude) highestAltitude = currentAltitude;
        }
        return highestAltitude;


        
    }
}
