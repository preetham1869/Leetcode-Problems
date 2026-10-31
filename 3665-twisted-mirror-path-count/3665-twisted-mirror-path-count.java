class Solution {
    private static final int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] memo = new int[m][n][2];
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] == 0) continue;

                if (c + 1 < n) {
                    int dest = getLanding(r, c + 1, 0, grid, m, n, memo);
                    if (dest != -1) {
                        int nr = dest / n;
                        int nc = dest % n;
                        dp[nr][nc] = (dp[nr][nc] + dp[r][c]) % MOD;
                    }
                }

                if (r + 1 < m) {
                    int dest = getLanding(r + 1, c, 1, grid, m, n, memo);
                    if (dest != -1) {
                        int nr = dest / n;
                        int nc = dest % n;
                        dp[nr][nc] = (dp[nr][nc] + dp[r][c]) % MOD;
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int getLanding(int r, int c, int d, int[][] grid, int m, int n, int[][][] memo) {
        if (r < 0 || r >= m || c < 0 || c >= n) return -1;
        if (grid[r][c] == 0) return r * n + c;
        if (memo[r][c][d] != 0) return memo[r][c][d];

        int res = (d == 0) 
            ? getLanding(r + 1, c, 1, grid, m, n, memo) 
            : getLanding(r, c + 1, 0, grid, m, n, memo);

        memo[r][c][d] = (res == -1) ? -2 : res;
        return res;
    }
}