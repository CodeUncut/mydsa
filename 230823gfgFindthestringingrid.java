Find the string in grid
MediumAccuracy: 22.88%Submissions: 62K+Points: 4
Win from a prize pool of INR 15K and get exciting merch! Register your team for Hack-A-Thon today!

Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

Note: The returning list should be lexicographically smallest. If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once. 

Example 1:

Input: 
grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: 
{{0,0}}
Explanation: 
From (0,0) we can find "abc" in horizontally right direction.
Example 2:

Input: 
grid = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}
word = "abe"
Output: 
{{0,0},{0,2},{1,0}}
Explanation: 
From (0,0) we can find "abe" in right-down diagonal. 
From (0,2) we can find "abe" in left-down diagonal. 
From (1,0) we can find "abe" in horizontally right direction.
Your Task:
You don't need to read or print anything, Your task is to complete the function searchWord() which takes grid and word as input parameters and returns a list containing the positions from where the word originates in any direction. If there is no such position then returns an empty list.

  
Expected Time Complexity: O(n*m*k) where k is constant
Expected Space Complexity: O(1)

Constraints:
1 <= n <= m <= 50
1 <= |word| <= 15

  and..

  class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int row[] = {-1,-1,0,1,1,1,0,-1};
        int col[] = {0,1,1,1,0,-1,-1,-1};
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                
                if(grid[i][j] == word.charAt(0)) {
                    int res = 0;
                    for(int k=0; k<8; k++) {
                        int r = i+row[k];
                        int c = j+col[k];
                        
                        int count = 0;
                        if(word.length() > 1) {
                            if(isSafe(r,c,1,grid,word,n,m)) {
                                count = solve(r,c,2,grid,word,n,m,row[k],col[k]);
                                if(count == 1) {
                                    res = 1;
                                    break;
                                }
                            }
                        }
                        else res = 1;
                    }
                    if(res == 1) {
                        ArrayList<Integer> abc = new ArrayList<>();
                        abc.add(i);
                        abc.add(j);
                        list.add(abc);
                    }
                }
            }
        }
        int arr[][] = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            arr[i][0] = list.get(i).get(0);
            arr[i][1] = list.get(i).get(1);
        }
        return arr;
    }
    boolean isSafe(int i, int j, int k, char[][] grid, String word, int n, int m) {
        if(i>=0 && i<n && j>=0 &&j<m &&grid[i][j] == word.charAt(k)) return true;
        return false;
    }
    
    int solve(int i, int j, int k, char[][] grid, String word, int n, int m, int row, int col) {
        if(k == word.length()) return 1;
        if(isSafe(i+row, j+col, k, grid, word, n, m)) {
            int count  = solve(i+row, j+col, k+1, grid, word, n, m, row, col);
            if(count == 1) return 1;
        }
        return 0;
    }
}
