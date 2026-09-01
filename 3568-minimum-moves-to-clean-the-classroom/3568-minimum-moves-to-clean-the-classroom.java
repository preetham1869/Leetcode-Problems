class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0, k = 0;
        int[][] id = new int[m][n];

        for (int[] row : id)
            Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = k++;
                }
            }
        }

        if (k == 0) return 0;

        int all = (1 << k) - 1;

        boolean[][][][] vis =
            new boolean[m][n][1 << k][energy + 1];

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{sr, sc, 0, energy, 0});
        vis[sr][sc][0][energy] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int e = cur[3];
            int moves = cur[4];

            if (mask == all)
                return moves;

            if (e == 0)
                continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (classroom[nr].charAt(nc) == 'X')
                    continue;

                int ne = e - 1;
                int nm = mask;

                if (classroom[nr].charAt(nc) == 'L')
                    nm |= 1 << id[nr][nc];

                if (classroom[nr].charAt(nc) == 'R')
                    ne = energy;

                if (!vis[nr][nc][nm][ne]) {
                    vis[nr][nc][nm][ne] = true;
                    q.add(new int[]{nr, nc, nm, ne, moves + 1});
                }
            }
        }
        return -1;
    }
}