class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int[] sa = new int[n];
        int[] rank = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = nums[i];
        }

        for (int k = 1; k < n; k *= 2) {
            final int len = k;
            final int[] rnk = rank;

            Integer[] idx = new Integer[n];

            for (int i = 0; i < n; i++) {
                idx[i] = sa[i];
            }

            Arrays.sort(idx, (a, b) -> {
                if (rnk[a] != rnk[b])
                    return Integer.compare(rnk[a], rnk[b]);

                int ra = a + len < n ? rnk[a + len] : -1;
                int rb = b + len < n ? rnk[b + len] : -1;

                return Integer.compare(ra, rb);
            });

            for (int i = 0; i < n; i++) {
                sa[i] = idx[i];
            }

            temp[sa[0]] = 0;

            for (int i = 1; i < n; i++) {
                int a = sa[i - 1];
                int b = sa[i];

                boolean different = rank[a] != rank[b];

                int ra = a + len < n ? rank[a + len] : -1;
                int rb = b + len < n ? rank[b + len] : -1;

                if (ra != rb) different = true;

                temp[b] = temp[a] + (different ? 1 : 0);
            }

            int[] swap = rank;
            rank = temp;
            temp = swap;

            if (rank[sa[n - 1]] == n - 1) break;
        }

        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[sa[i]] = i;
        }

        int[] lcp = new int[n];
        int h = 0;

        for (int i = 0; i < n; i++) {
            int r = pos[i];

            if (r == 0) continue;

            int j = sa[r - 1];

            while (i + h < n && j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[r] = h;

            if (h > 0) h--;
        }

        int ans = n;

        for (int i = 0; i < n; i++) {
            int left = i > 0 ? lcp[i] : 0;
            int right = i + 1 < n ? lcp[i + 1] : 0;

            int need = Math.max(left, right) + 1;

            if (sa[i] + need <= n) {
                ans = Math.min(ans, need);
            }
        }

        return ans;
    }
}