class Solution{
    // Function for finding maximum and value pair
    public long sumXOR (int arr[], int n) {
        long[] hsh = new long[32];
        long ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<32;j++)
            {
                if((arr[i]&(1<<j))>0)
                {
                    ans+=(1<<j)*(i-hsh[j]);
                    hsh[j]++;
                }
                else
                {
                    ans+=(1<<j)*(hsh[j]);
                }
            }
        }
        return ans;
    }
}
