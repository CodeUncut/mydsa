class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    public static int mod = 1000000007;
    static long countWays(int n)
    {
        // add your code here
        long dp[]=new long[n+1];
        Arrays.fill(dp,-1);
        return countWaysU(n,dp);
        
    }
    static long countWaysU(int n,long dp[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!= -1){
            return dp[n];
        }
        else{
            long first=countWaysU(n-1,dp);
            long second=countWaysU(n-2,dp);
            long third=countWaysU(n-3,dp);
            return dp[n]=(first + second + third)%mod;
        }
    }
    
}
