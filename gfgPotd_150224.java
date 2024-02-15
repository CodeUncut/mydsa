class Solution {
    public int isPossible(int[][] paths) {
        int n = paths.length;

        // Check the degree of each vertex
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += paths[i][j];
            }
            if (degree % 2 != 0) {
                // If any vertex has an odd degree, return 0
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example
        int[][] paths = {
            {0, 1, 1, 1, 1},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };
        System.out.println(solution.isPossible(paths));  // Output: 1
    }
}
