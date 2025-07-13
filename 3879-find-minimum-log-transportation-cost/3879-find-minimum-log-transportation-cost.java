class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if(n <= k && m <= k)return 0;
        long minC= Long.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            if (i <= k && n - i <= k && m <= k)
                minC= Math.min(minC, 1L*i * (n - i));
        }
        for (int i = 1; i < m; i++) {
            if (i <= k && m - i <= k && n <= k)
                minC=Math.min(minC, 1L*i * (m - i));
        }
        return minC;
    }
}