class Solution {
    // optimized approach
    public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        long p=1;
        int ans=0,i=0,j=0;
        for(i=0, j=0; j<n ; j++)
        {
            p = p*a[j];
            while(p>=k && i<j)
            {
                p/=a[i];
                i++;
            }
            
            if(p<k)
            ans+= (j-i+1);
        
        }
        return ans;
    }
    
}
