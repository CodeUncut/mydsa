class Solution

{

    //Function to return sum of upper and lower triangles of a matrix.

    static ArrayList<Integer> sumTriangles(int matrix[][], int n)

    {

    ArrayList<Integer> list=new ArrayList<>();

      int r = n;

      int c = matrix[0].length;

      int up = 0;

      int down = 0;

      for(int i =0;i<r;i++){

          for(int j=i+0;j<c;j++){

              up =up+matrix[i][j];

          }

      }

      list.add(up);

      for(int i=0;i<r;i++){

          for(int j=0;j<=i;j++){

              down=down+matrix[i][j];

          }

      }

      list.add(down);

      return list;

    }

}
