
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
  public:
    long long maxDiamonds(int A[], int N, int k) {
        priority_queue<int> pq;
    for (int i = 0; i < N; i++)
        pq.push(A[i]);
    long long ans = 0;
    for (int i = 0; i < k; i++) {
        int curr = pq.top();
        pq.pop();
        ans += curr;
        pq.push(curr / 2);
    }
    return ans;
    }
};
