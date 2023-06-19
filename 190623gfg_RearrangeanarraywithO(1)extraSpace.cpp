class Solution{
    public:
    // arr: input array
    // n: size of array
    //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    //with O(1) extra space.
    void arrange(long long arr[], int n) {
        // Your code here
        for(int i = 0; i <n ;i ++)
        {
          
            arr[i] += (arr[(int)arr[i]]%n)*n;    
            // for the next iteration , we want the old values again for computation of arr[i],
            // and for the retireval of old value we use %n as shown above
        }
        
         for(int i = 0; i <n ;i ++)
         arr[i] /= n;
    }
};
