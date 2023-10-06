#include<iostream>
#include<vector>
#include<map>
using namespace std;

/**
 * Prompt: we are given a tree graph where k of the vertices are bad (indicated with cats) and we want
 to find all the paths from the root to leaves where there are not k consecutive bad vertices


 High level sol: 
    - Construct graph using adjacency list
    - mark each node that is bad
    - dfs from the root and keep track of how many bad vertices seen so far
    - If at any point there are more than m bad veritces in a row, stop traversing that path
    - If we get to a leaf, increment the total paths

TC: O(V)  SC: O(V) note these are not O(V+E) because E = V - 1 since it is a tree


GLOBAL VARIABLES WERE NECESSARY TO MEET TIME CONSTRAINT ON CODEFORCES
*/



void dfs(int, int);
bool isLeaf(vector<int>);

bool visited[100010];
int hasCat[100010];
int n, m, cnt = 0;
vector< vector<int> > adjList;

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int catAtNodeI;
        cin >> catAtNodeI;
        hasCat[i] = catAtNodeI;

        vector<int> nodeI;
        adjList.push_back(nodeI);
        visited[i] = false;
    }

    for (int i = 0; i < (n-1); i++) {
        int u, v; 
        cin >> u >> v;

        adjList[u-1].push_back(v-1);
        adjList[v-1].push_back(u-1);
    }
    dfs(0,0);
    cout << cnt << endl;

    return 0;
}

bool isLeaf(vector<int> nodeAdjList) {
    return nodeAdjList.size() == 1;
}

void dfs(int curNode,int currK) {
    
    if(visited[curNode]) return;

    visited[curNode] = true;
    int numEdges = adjList[curNode].size();
    if (hasCat[curNode]) currK++;
    else currK = 0;


    if (currK > m) return;

    if (curNode != 0 && isLeaf(adjList[curNode])) {
        cnt++;
    }
    for(int i = 0; i < numEdges; i++) { 
        dfs(adjList[curNode][i], currK); // keep traversing if have not seen k consecutive cats
    }

}

