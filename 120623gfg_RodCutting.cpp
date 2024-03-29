class Solution{
  public:
    int cutRod(int price[], int n) {
        //code here
        int dp[n+1]= {0};
        for(int i=1; i<=n; i++){
            int temp = INT_MIN;
            for(int j=0; j<i; j++){
                temp = max(temp, price[j]+ dp[i-j -1]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }
};
