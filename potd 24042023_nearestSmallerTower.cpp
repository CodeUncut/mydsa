// Nearest smallest tower

/*
Given an array where each element (arr[i]) represents the height of the tower. Find for each tower, the nearest possible tower that is shorter than it. You can look left or right on both sides.
Note : 

If two smaller towers are at the same distance, pick the smallest tower.

If two towers have the same height then we choose the one with a smaller index.

Example 1:

Input: 
arr[] = {1,3,2}
Output: 
{-1,0,0}
Explanation:
For 0th Index : no tower is smallest, so -1.
For 1st Index : For 3, here 1 & 2 both are 
small & at a same distance, so we will pick 1, 
beacuse it has smallest value, so 0(Index)
For 2nd Index : here 1 is smaller, so 0(Index)
So the final output will be which consistes 
Indexes are {-1,0,0}.
Example 2:

Input: 
arr[] = {4,8,3,5,3}
Output: 
{2,2,-1,2,-1}

Explanation: 
For 0th Index : here 3 is the smaller, so 2(Index) 
For 1st Index : For 8, here 4 & 3 both are
small & at a same distance, so we will pick 3, so 2(Index)
For 2nd Index : no tower is smallest, so -1.
For 3rd Index : For 5, here 3 & 3 both are
small & at a same distance, so we will pick 
3(2nd Index) because it smaller Index, so 2(Index)
For 4th Index : no tower is smallest, so -1.
So the final output will be which consistes
Indexes are {2,2,-1,2,-1}.
*/

//Answer:

class Solution
{
public:
    vector<int> nearestSmallerTower(vector<int> arr)
    {
        // code here
        int n = arr.size();
        stack<int> st;
        int left[n], right[n];
        vector<int> ans(n);
        
        // left smallest
        
        for(int i=0; i<n; i++)
        {
            while(st.size() && arr[st.top()]>=arr[i])st.pop();
            
            if(st.size())left[i] = st.top();
            else left[i] = -1;
            st.push(i);
        }
        
        while(st.size())st.pop();
        
        //for Right
        for(int i= n-1; i>=0; i--)
        {
            while(st.size() && arr[st.top()]>=arr[i])st.pop();
            
            if(st.size())right[i] = st.top();
            else right[i] = -1;
            st.push(i);
        }
        
        for (int i=0; i<n;i++)
        {
            if(left[i] == right[i])ans[i]=-1;
            else if(left[i]==-1)ans[i]= right[i];
            else if(right[i] ==-1)ans[i] =left[i];
            else if(i-left[i] < right[i]-i) ans[i] =left[i];
            else if(i- left[i] > right[i]-i) ans[i] =right[i];
            else if(arr[right[i]] < arr[left[i]]) ans[i] = right[i];
            // else if(arr[right[i]]> arr[left[i]]) ans[i] =left[i];
            else ans[i] = left[i];
        }
        return ans;
    }
};