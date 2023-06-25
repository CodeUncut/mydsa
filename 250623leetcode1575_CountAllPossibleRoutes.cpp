class Solution {
public:
    int fin;
    vector<int> loc;
    int dp[105][205] = {0};
 
    int recur(int idx, int fuel) {
        int ans = 0;
        if(idx == fin) {
            ans++;
        }
        if(dp[idx][fuel] != -1) {
            return dp[idx][fuel];
        }
 
        for(int i=0; i<loc.size(); i++) {
            if(i != idx && abs(loc[i] - loc[idx]) <= fuel) {
                ans += recur(i, fuel - abs(loc[i] - loc[idx]));
                ans %= 1000000007;
            }
        }
        return dp[idx][fuel] = ans;
    }
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        fin = finish;
        loc = locations;
        memset(dp, -1, sizeof(dp));
        return recur(start, fuel);
    }
};
