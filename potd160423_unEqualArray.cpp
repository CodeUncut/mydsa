//Unequal Arrays

/*
You are given two arrays A and B each of length N. You can perform the following operation on array A zero or more times. 

Select any two indices i and j, 1 <= i , j <= N and i != j
Set A[i] = A[i] + 2 and A[j] = A[j]-2
Find the minimum number of operations required to make A and B equal.

Note :

Two arrays are said to be equal if the frequency of each element is equal in both of them.
Arrays may contain duplicate elements.
Example 1:

Input:
N = 3
A[] = {2, 5, 6}
B[] = {1, 2, 10}
Output: 2
Explanation: 
Select i = 3, j = 2, A[3] = 6 + 2 = 8 and A[2] = 5 - 2 = 3
Select i = 3, j = 2, A[3] = 8 + 2 = 10 and A[2] = 3 - 2 = 1
Now A = {2, 1, 10} and B = {1, 2, 10}
Example 2:

Input:
N = 2
A[] = {3, 3}
B[] = {9, 8}
Output: -1
Explanation: 
It can be shown that A cannot be made equal to B.
*/

class Solution {
  public:
    long long solve(int N, vector<int> &A, vector<int> &B) {
        // code here
        long long sum=0,ans=0;
        vector<int> a,b,c,d;
        sort(A.begin(),A.end());
        sort(B.begin(),B.end());
        for(int i=0;i<N;i++){
            sum+=A[i]-B[i];
            if(A[i]%2!=0)a.push_back(A[i]);
            else b.push_back(A[i]);
            if(B[i]%2!=0)c.push_back(B[i]);
            else d.push_back(B[i]);
        }
        if(sum!=0 || a.size()!=c.size())return -1;
        for(int i=0;i<a.size();i++){
            ans+=(abs(a[i]-c[i])/2);
        }
        for(int i=0;i<b.size();i++){
            ans+=(abs(b[i]-d[i])/2);
        }
        return ans/2;
    }
};