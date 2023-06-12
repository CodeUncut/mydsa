class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[]= new int[n+1];
        Arrays.fill(dp,0);
        for(int i=1; i<=n; i++){
            int temp = Integer.MIN_VALUE;
            for(int j=0; j<i; j++){
                temp = Math.max(temp, price[j]+ dp[i-j -1]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}
