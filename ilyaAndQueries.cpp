/**
 * Prompt: We are given a string cosisting of '.' and '#' our goal is given two integers: li, ri (1 ≤ li < ri ≤ n)
 *         see how many characters within s[li] and s[ri] such that s[i] = s[i+1]
 * High level solution:
 *  - Keep a prefix sum of the total neighbors seen so far
 *  - for each query (ri, li) perform prefixSum[li] - prefixSum[ri]
*/

#include<iostream>

using namespace std;


int main() {
    string input;
    int numQueries;

    cin >> input >> numQueries;

    int prefixSum[input.length()];
    prefixSum[0] = 0;

    int totalNeighbors = 0;

    for (int i = 1; i < input.length(); i++) {

        if (input[i] == input[i-1]) totalNeighbors++;

        prefixSum[i] = totalNeighbors;
    }

    int numNeighbors[numQueries];
    for (int i = 0; i < numQueries; i++) {

        int start, end;

        cin >> start >> end;

        int currNumNeighbors;
        if (start <= 1) currNumNeighbors = prefixSum[end - 1];
        else currNumNeighbors = prefixSum[end - 1] - prefixSum[start - 1];

        numNeighbors[i] = currNumNeighbors;
    }


    for (int i = 0; i < numQueries; i++) {
        cout << numNeighbors[i] << endl;

    }

    return 0;
}
