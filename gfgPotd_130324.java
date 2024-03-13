class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        
        int row = mat.length;
        int col = mat[0].length;
        
        int n = row;
        
        int count = 0;
        int ans[] = new int[row*col];
        int ev = 0;
        
        for(int i=0;i<n;i++){
            if(ev%2==0){//down to up
                int pos = i;
                for(int j=0;j<=i;j++){
                    ans[count++] = mat[pos][j];
                    pos--;
                }
            }else{
                int pos = 0;
                for(int j=i;j>=0;j--){
                    ans[count++] = mat[pos][j];
                    pos++;
                }
            }
            ev++;
        }
        for(int i=1;i<n;i++){
            if(ev%2==0){
                int pos = n-1;
                for(int j=i;j<n;j++){
                    ans[count++] = mat[pos][j];
                    pos--;
                }
            }else{
                int pos = i;
                for(int j=n-1;j>=i;j--){
                    ans[count++] = mat[pos][j];
                    pos++;
                }
            }
            ev++;
        }
        return ans;

    }
}
