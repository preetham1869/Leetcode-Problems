class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;
                    int changes = 0;

                    for (int r = 0; r < d; r++) {
                        int l = i + r;
                        int right = j - (d - 1 - r);

                        while (l < right) {
                            if (s.charAt(l) != s.charAt(right)) {
                                changes++;
                            }
                            l += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int p = 1; p <= k; p++) {
                for (int j = 0; j <= i - 2; j++) {
                    dp[i][p] = Math.min(dp[i][p], dp[j][p - 1] + cost[j][i - 1]);
                }
            }
        }

        return dp[n][k];
    }
}
