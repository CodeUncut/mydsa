class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        int ans = 0;
        //staring from last second last col
        for(int col=m-2;col>=0;col--){
            for(int row=0;row<n;row++){
                int temp = M[row][col+1];
                if(row-1>=0){
                    temp = Math.max(M[row-1][col+1],temp);
                }
                if(row+1<n){
                 temp = Math.max(M[row+1][col+1],temp);
                }
                M[row][col] = M[row][col] + temp;
                if(col==0){
                    ans = Math.max(M[row][col],ans);
                }
            }
        }
        return ans;
    }
}
