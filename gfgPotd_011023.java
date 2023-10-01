class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        //base case if number of row or column is 1 then adding all elements.
        if(n == 1)
        {
            int i = 0;
            while(i < m)
                output.add(matrix[0][i++]);
        }
        else if(m == 1)
        {
            int i = 0;
            while(i < n)
                output.add(matrix[i++][0]);
        }
        else
        {   
            //we take care of fact that we don't add any number multiple times.
            
            //traversing first row and adding elements in the list.
            for(int j=0;j<m;j++)
                output.add(matrix[0][j]);
            
            //traversing last column and adding elements in the list.
            for(int j=1;j<n;j++)
                output.add(matrix[j][m-1]);
            
            //traversing last row and adding elements in the list.
            for(int j=m-2;j>=0;j--)
                output.add(matrix[n-1][j]);
            
            //traversing first column and adding elements in the list.
            for(int j=n-2;j>=1;j--)
                output.add(matrix[j][0]);
        }   
        //returning the list.
        return output; 
    }
}
