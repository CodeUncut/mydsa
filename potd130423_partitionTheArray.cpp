//Partition The Array

/*Given an array A[] of N integers. The task is to partition the array into four non-empty contiguous subarrays P, Q, R, and S such that each element of the array A[] should be present in any subarray.
Let W, X, Y, and Z be the sum of the elements in P, Q, R, and S respectively.
Find the smallest absolute difference between the maximum and the minimum among W, X, Y, and Z.

Example 1:

Input:
N = 5
A[] = [4,2,2,5,1]
Output: 4
Explanation: let partition the array 
P,Q,R,S = [4],[2,2],[5],[1]
W = 4, X = 4, Y = 5, Z = 1 
Differnce = max(W,X,Y,Z)-min(W,X,Y,Z)= 5-1 = 4 
Example 2:

Input:
N = 4
A[] = {4,4,4,4}
Output: 0
Explanation: 
There is only one way to partition 
the array. P,Q,R,S = [4],[4],[4],[4]*/



//Answer:

int binarySearch(long long arr[],int low,int high,long long sum,long long temp){
        int mid,index=-1;
        long long first,second,diff=INT_MAX;
        while(low<=high){
            mid=(low+high)/2;
            first=arr[mid]-temp;
            second=sum-arr[mid];
            if(abs(first-second)<diff){
                index=mid;
                diff=abs(first-second);
            }
            if(first<second){
                low=mid+1;
            }
            else high=mid-1;
        }
        return index;
    }
    long long minDifference(int N, vector<int> &A) {
        // code here
        long long arr[N];
        arr[0]=A[0];
        for(int i=1;i<N;i++){
            arr[i]=A[i]+arr[i-1];
        }
        long long ans = INT_MAX,w,x,y,z;
        for(int i=2;i<N-1;i++){
            int index = binarySearch(arr,0,i-1,arr[i-1],0);
            w=arr[index];
            x=arr[i-1]-w;
            index = binarySearch(arr,i,N-1,arr[N-1],arr[i-1]);
            y=arr[index]-arr[i-1];
            z=arr[N-1]-arr[index];
            ans=min(ans,max({w,x,y,z})-min({w,x,y,z}));
        }
        return ans;
    }
