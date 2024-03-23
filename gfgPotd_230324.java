class Solution {

    int[] Series(int n) {
        // code here
        int mod=(int)1e9+7;
        int[] ans=new int[n+1];
        ans[1]=1;
        for(int i=2;i<=n;i++){
            ans[i]=((ans[i-1]%mod)+(ans[i-2]%mod))%mod;
        }
        return ans;
    }
}
