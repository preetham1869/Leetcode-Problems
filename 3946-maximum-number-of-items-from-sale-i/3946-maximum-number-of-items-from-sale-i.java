class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = 1;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    val[i]++;
                }
            }
        }

        int minIndex = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (items[i][1] < minPrice) {
                minPrice = items[i][1];
                minIndex = i;
            }
        }

        int ans = 0;
        int INF = -1000000;

        int[] dp = new int[budget + 1];
        java.util.Arrays.fill(dp, INF);

        if (minPrice <= budget) {
            dp[minPrice] = val[minIndex];

            for (int i = 0; i < n; i++) {
                if (i == minIndex) continue;

                int cost = items[i][1];

                for (int b = budget; b >= cost; b--) {
                    if (dp[b - cost] != INF) {
                        dp[b] = Math.max(dp[b],
                                dp[b - cost] + val[i]);
                    }
                }
            }

            for (int b = minPrice; b <= budget; b++) {
                if (dp[b] != INF) {
                    ans = Math.max(ans,
                            dp[b] + (budget - b) / minPrice);
                }
            }
        }

        int[] dp2 = new int[budget + 1];
        java.util.Arrays.fill(dp2, INF);
        dp2[0] = 0;

        for (int i = 0; i < n; i++) {
            if (i == minIndex) continue;

            int cost = items[i][1];

            for (int b = budget; b >= cost; b--) {
                if (dp2[b - cost] != INF) {
                    dp2[b] = Math.max(dp2[b],
                            dp2[b - cost] + val[i]);
                }
            }
        }

        for (int b = 0; b <= budget; b++) {
            if (dp2[b] == INF) continue;

            int remaining = budget - b;

            ans = Math.max(ans, dp2[b]);

            if (remaining >= minPrice) {
                ans = Math.max(ans,
                        dp2[b] + val[minIndex]
                        + (remaining - minPrice) / minPrice);
            }
        }

        return ans;
    }
}
