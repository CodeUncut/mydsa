class Solution
{
    public int MaxMoney(int arr[], int idx, int dp[]){
        if(idx < 0) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        int pickMoney = arr[idx] + MaxMoney(arr, idx-2, dp);
        int notPickMoney = 0 + MaxMoney(arr, idx-1, dp);
        
        return dp[idx] = Math.max(pickMoney, notPickMoney);
    }
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return MaxMoney(arr, n-1, dp);
    }
}

