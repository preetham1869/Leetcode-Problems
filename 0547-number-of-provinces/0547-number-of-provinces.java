class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                cnt++;
            }
        }
        return cnt;
    }
    void dfs(int[][] grid, boolean[] visited, int city) {
        visited[city] = true;
        for (int j = 0; j < grid.length; j++) {
            if (grid[city][j] == 1 && !visited[j]) {
                dfs(grid, visited, j);
            }
        }
    }
}