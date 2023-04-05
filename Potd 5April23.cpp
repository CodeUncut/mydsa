/*Count Special Numbers

You are given an array arr[ ] of size N consisting of only positive integers. Your task is to find the count of special numbers in the array. A number is said to be a special number if it is divisible by at least 1 other element of the array.

Example 1:

Input:
N = 3
arr[] = {2, 3, 6}
Output:
1
Explanation:
The number 6 is the only special number in the
array as it is divisible by the array elements 2 
and 3. Hence, the answer is 1 in this case.

*/
//Answer
class Solution {
  public:
    int countSpecialNumbers(int N, vector<int> arr) {
        // Code here
        
        int mx=INT_MIN;
        for(int i=0;i<N; i++)
        {
            mx=max(mx,arr[i]);
        }
        vector<int>temp(mx+1,0);
        
        for(int i=0;i<N; i++)
        {
            if(temp[arr[i]]<=1)
            {
                for(int j=arr[i]; j<=mx; j+=arr[i])
                {
                    temp[j]++;
                }
            }
        }
        
        int count=0;
        for(int i=0;i<N; i++)
        {
            if(temp[arr[i]]>1)
            {
                count++;
            }
            
        }
        
        return count;
    }
};