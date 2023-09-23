class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        if(n==1){
            return 1;
        }
        long[] sum = new long[n];
        long s = 0, lsum = 0, rsum = 0;
        
        for(int i=0; i<n;i++){
            s+=arr[i];
            sum[i] = s;
        }
        
        for(int i=1; i<n; i++){
            lsum = sum[i] - arr[i];
            rsum = sum[n-1] - sum[i];
            if(lsum == rsum){
                return i+1;
            }
        }
        return -1;
        // Your code here
    }
}
