class Solution

{

    //Function to modify the matrix such that if a matrix cell matrix[i][j]

    //is 1 then all the cells in its ith row and jth column will become 1.

    void booleanMatrix(int matrix[][])

    {

        // code here 

        int n=matrix.length,m=matrix[0].length;

        int col0=0;

        if(matrix[0][0]==1) col0=1;

        for(int i=0;i<n;i++){

            if(matrix[i][0]==1) matrix[0][0]=1;

        }

        for(int j=1;j<m;j++){

            if(matrix[0][j]==1) col0=1;

        }

        for(int i=1;i<n;i++){

        for(int j=1;j<m;j++){

            if(matrix[i][j]==1){

                matrix[i][0]=1;

                matrix[0][j]=1;

            }

        }

        }

       

        for(int i=n-1;i>=0;i--){

        for(int j=m-1;j>=0;j--){

            if(i==0 && col0==1) matrix[i][j]=1;

            if(i!=0 && (matrix[0][j]==1 || matrix[i][0]==1)) matrix[i][j]=1;

        }

        }

    }

}
