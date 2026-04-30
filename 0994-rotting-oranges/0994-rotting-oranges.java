class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int good = 0, time = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {   // fixed cols → c
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                else if (grid[i][j] == 1) good++;
            }
        }
        int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty() && good > 0) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int[] cur = q.poll();
                for (int[] dir : d) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        good--;
                    }
                }
            }
            time++;
        }
        return good == 0 ? time : -1;
    }
}