class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        int [][]vis = new int[n][m];
        int [][]temp = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || i==n-1 || j==0 || j==m-1 ){
                    if(a[i][j] == 'O' && vis[i][j] == 0){
                        queue.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                   
                }
            }
        }
        // System.out.println(queue);
        int [] delrow = {-1, 0, +1, 0};
        int [] delcol = {0, +1, 0, -1};
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            for(int i=0; i<4; i++){
                int nrow = p.row + delrow[i];
                int ncol = p.col + delcol[i];
                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && a[nrow][ncol] == 'O' && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
        char [][] ans = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && a[i][j] == 'O') a[i][j] = 'X';
                
            }
        }
        return a;
    }
}
