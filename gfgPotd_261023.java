class Solution
{
    public int minOperation(int n)
    {
        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                d[i] = d[i / 2] + 1;
            } else {
                d[i] = d[i - 1] + 1;
            }
        }
        return d[n];
    }
}
