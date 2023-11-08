class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        // code here 
        int l = matrix.length;
        ArrayList<Integer> snake = new ArrayList<>();
        for(int i = 0;i<l;i++)
        {
            //value of j, and its increment and decrement for odd and even values of i
            for(int j = (l-1)*(i%2);j>=0&&j<l; j = j + (i%2)*(-2) + 1)
            {
                snake.add(matrix[i][j]);
            }   
        }
        return snake;
    }
}
