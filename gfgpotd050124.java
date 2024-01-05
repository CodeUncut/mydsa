class Solution
{
    public int TotalWays(int N)
    {
        int MOD = 1000000007;
        int[] a = new int[N];
        
        for(int i = N - 1; i >= 0; i--)
        {
            int x = 0;
            
            if (i + 2 < N) 
                x = a[i + 2] % MOD;
            
            a[i] = 1 + x;
            
            if (i < N - 1) 
                a[i] = (a[i] + a[i + 1]) % MOD;
        }

        
        int temp = (a[0] + 1) % MOD;

        
        int ans = (int)(((long)temp * temp) % MOD);

        return ans;
    }
}
