class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> x[1] != y[1]
                ? Integer.compare(x[1], y[1])
                : Integer.compare(x[3], y[3]));

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int l = 0, r = i - 1;
            prev[i] = -1;

            while (l <= r) {
                int m = (l + r) >>> 1;

                if (a[m][1] < a[i][0]) {
                    prev[i] = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        Node[][] dp = new Node[5][n + 1];

        for (int i = 0; i <= n; i++)
            dp[0][i] = new Node(0, new int[0]);

        for (int k = 1; k <= 4; k++) {
            for (int i = 1; i <= n; i++) {
                Node skip = dp[k][i - 1];
                Node take = null;

                Node p = dp[k - 1][prev[i - 1] + 1];

                if (p != null) {
                    int[] ids = insertSorted(p.ids, a[i - 1][3]);

                    take = new Node(
                        p.score + a[i - 1][2],
                        ids
                    );
                }

                dp[k][i] = better(take, skip) ? take : skip;
            }
        }

        Node ans = dp[0][n];

        for (int k = 1; k <= 4; k++) {
            if (better(dp[k][n], ans))
                ans = dp[k][n];
        }

        return ans.ids;
    }

    private int[] insertSorted(int[] ids, int x) {
        int n = ids.length;
        int[] res = new int[n + 1];

        int pos = 0;

        while (pos < n && ids[pos] < x) {
            res[pos] = ids[pos];
            pos++;
        }

        res[pos] = x;

        while (pos < n) {
            res[pos + 1] = ids[pos];
            pos++;
        }

        return res;
    }

    private boolean better(Node a, Node b) {
        if (a == null)
            return false;

        if (b == null)
            return true;

        if (a.score != b.score)
            return a.score > b.score;

        for (int i = 0; i < a.ids.length; i++) {
            if (a.ids[i] != b.ids[i])
                return a.ids[i] < b.ids[i];
        }

        return false;
    }

    static class Node {
        long score;
        int[] ids;

        Node(long score, int[] ids) {
            this.score = score;
            this.ids = ids;
        }
    }
}