// Geek's Village and Well

/* Question

Geek's village is represented by a 2-D matrix of characters of size n*m, where

H - Represents a house
W - Represents a well
. - Represents an open ground
N - Prohibited area(Not allowed to enter this area)

Every house in the village needs to take water from a well, as the family members are so busy with their work, so every family wants to take the water from a well in minimum time, which is possible only if they have to cover as less distance as possible. Your task is to determine the minimum distance that a person in the house should travel to take out the water and carry it back to the house.

A person is allowed to move only in four directions left, right, up, and down. That means if he/she is the cell (i,j), then the possible cells he/she can reach in one move are (i,j-1),(i,j+1),(i-1,j),(i+1,j), and the person is not allowed to move out of the grid.

Note: For all the cells containing 'N', 'W' and '.' our answer should be 0, and for all the houses where there is no possibility of taking water our answer should be -1.

Example 1:

Input:
n = 3
m = 3
c[][]: H H H
       H W H
       H H H
Output:
4 2 4 
2 0 2 
4 2 4
Explanation:
There is only one well hence all the houses present
in the corner of matrix will have to travel a minimum
distance of 4, 2 is for house to well and other two is
for well to house. And rest of the houses have to travel
a minimum distance of 2 (House -> Well -> House).
Example 2:

Input:
n = 5
m = 5
c[][]: H N H H H
       N N H H W
       W H H H H
       H H H H H
       H H H H H
Output:
-1 0 6 4 2 
0 0 4 2 0 
0 2 4 4 2 
2 4 6 6 4 
4 6 8 8 6
Explanation:
There is no way any person from the house in
cell (0,0) can take the water from any well, and
for rest of the houses there is same type of
strategy we have to follow as followed in example 1. 
*/

// Answer in Java

class pair
{
    int first,second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution
{
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int ans[][] = new int[n][m];
        for(int []temp:ans){
            Arrays.fill(temp,-1);
        }
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='W'){
                    q.add(new pair(i,j));
                    ans[i][j]=0;
                }
            }
        }
        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};
        while(q.size()!=0){
            pair temp = q.remove();
            int i = temp.first;
            int j = temp.second;
            for(int k=0;k<4;k++){
                int newi=i+x[k];
                int newj=j+y[k];
                if(newi<n && newi>=0 && newj<m && newj>=0 
                && c[newi][newj]!='N' && ans[newi][newj]==-1){
                    ans[newi][newj]=ans[i][j]+1;
                    q.add(new pair(newi,newj));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='N' || c[i][j]=='.')ans[i][j]=0;
                else if(ans[i][j]!=-1)ans[i][j]*=2;
            }
        }
        return ans;
    }
}