// Split Array Largest Sum - 13 December

/*Given an array arr[] of N elements and a number K. Split the given array into K subarrays such that the maximum subarray sum achievable out of K subarrays formed is minimum possible. Find that possible subarray sum.


Example 1:

Input:
N = 4, K = 3
arr[] = {1, 2, 3, 4}
Output: 4
Explanation:
Optimal Split is {1, 2}, {3}, {4}.
Maximum sum of all subarrays is 4,
which is minimum possible for 3 splits. 
Example 2:

Input:
N = 3, K = 2
A[] = {1, 1, 2}
Output:
2
Explanation:
Splitting the array as {1,1} and {2} is optimal.
This results in a maximum sum subarray of 2.*/

//Answer
//Should be placed inside Solution

bool isPossible(int mid, int N, int arr[], int K)
  {
      int Count = 1, sum = 0;
      for(int i=0;i<N;i++)
      {
          sum += arr[i];
          if(sum>mid)
          {
              Count++;
              sum =arr[i];
          }
      }
      return K>=Count;
  }
    int splitArray(int arr[] ,int N, int K) {
        // code here
        
        int low= INT_MIN, high =0;
        for(int i=0;i<N;i++)
        {
            low=max(low,arr[i]);
            high +=arr[i];
        }
        // low= 4;
        // high = 10;
        
        //Using Binary Search
        int ans = INT_MAX;
        while(low<=high){
                int mid = (low+high)/2;
                if(isPossible(mid,N,arr,K)){
                    ans= min(ans,mid);
                    high =mid-1;
                }
                else{
                    low = mid+1;
                }
        }
        return ans;
    }