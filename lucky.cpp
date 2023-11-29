
/**
 * Prompt: A ticket is a string consisting of six digits. A ticket is considered lucky 
 * if the sum of the first three digits is equal to the sum of the last three digits. 
 * Given a ticket, output if it is lucky or not. Note that a ticket can have leading zeroes.
 * The description of each test consists of one line containing one string consisting of six digits.

For solution, can either use prefix sum or simply see if the sum of the first three elements equal the sum of the last three elements. 
*/


#include<iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int prefixSum[6];
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        int pSum = 0;
        for(int j = 0; j < 6; j++) {
            pSum += (int) s[j];
            prefixSum[j] = pSum;
        }
        if (prefixSum[2] == prefixSum[5] - prefixSum[2]) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
    return 0;
}
