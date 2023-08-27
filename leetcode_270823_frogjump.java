class Solution {
    private boolean memoizationUtil(int[] stones, int postion, int jump, Map<Integer, Integer> map, Boolean[][] dp) {
		if (postion == stones.length - 1) {
			return true;
		}
		if (dp[postion][jump] != null) {
			return dp[postion][jump];
		}
		boolean local = false;
		if (map.containsKey(stones[postion] + jump - 1) && jump - 1 > 0)
			local = local || memoizationUtil(stones, map.get(stones[postion] + jump - 1), jump - 1, map, dp);
		if (map.containsKey(stones[postion] + jump) && jump > 0)
			local = local || memoizationUtil(stones, map.get(stones[postion] + jump), jump, map, dp);
		if (map.containsKey(stones[postion] + jump + 1))
			local = local || memoizationUtil(stones, map.get(stones[postion] + jump + 1), jump + 1, map, dp);
		dp[postion][jump] = local;
		return local;
	}

	private boolean memoization(int[] stones) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = stones.length;
		for (int i = 0; i < n; i++) {
			map.put(stones[i], i);
		}
		Boolean[][] dp = new Boolean[n][n];
		return memoizationUtil(stones, 0, 0, map, dp);
	}
    public boolean canCross(int[] stones) {
        return memoization(stones);
    }
}
