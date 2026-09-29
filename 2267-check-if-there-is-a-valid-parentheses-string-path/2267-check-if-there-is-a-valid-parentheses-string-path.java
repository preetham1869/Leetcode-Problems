class Solution {

    int m, n;
    char[][] grid;
    boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 != 0)
            return false;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        dp = new boolean[m][n][m + n];

        return dfs(0, 0, 0);
    }

    boolean dfs(int r, int c, int bal) {

        if (bal < 0)
            return false;

        if (grid[r][c] == '(')
            bal++;
        else
            bal--;

        if (bal < 0)
            return false;

        if (r == m - 1 && c == n - 1)
            return bal == 0;

        if (dp[r][c][bal])
            return false;

        dp[r][c][bal] = true;

        if (r + 1 < m && dfs(r + 1, c, bal))
            return true;

        if (c + 1 < n && dfs(r, c + 1, bal))
            return true;

        return false;
    }
}