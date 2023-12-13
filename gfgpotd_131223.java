class Solution {
    long countStrings(int n) {
        long mod=1000000007L;
        long a[][] = new long[n][2];
        a[0][0] = 2;
        a[0][1] = 1;
        for(int i =1;i<n;i++){
            a[i][0] = (a[i-1][0]  + a[i-1][1])%mod;
            a[i][1] = a[i-1][0]%mod;
        }
        return a[n-1][0]%mod ;
        
        
    }
}
