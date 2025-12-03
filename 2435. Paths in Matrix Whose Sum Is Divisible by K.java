class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][k];
        dp[0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            int[][] newDp = new int[n][k];
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                int r = val % k;

                if (i == 0 && j == 0) {
                    newDp[0][r] = (newDp[0][r] + 1) % MOD;
                    continue;
                }
                for (int mod = 0; mod < k; mod++) {
                    int prev = (mod - r + k) % k;
                    if (i > 0) newDp[j][mod] = (newDp[j][mod] + dp[j][prev]) % MOD;
                    if (j > 0) newDp[j][mod] = (newDp[j][mod] + newDp[j-1][prev]) % MOD;
                }
            }
            dp = newDp;
        }
        return dp[n - 1][0];
    }
}
