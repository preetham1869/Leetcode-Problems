class Solution {
    public long maximumProfit(int[] prices, int k) {
       int n = prices.length;
        long[][] prev = new long[k + 1][3];
        long[][] curr = new long[k + 1][3];
        for (int t = 1; t <= k; t++) {
            prev[t][1] = -prices[0];
            prev[t][2] = prices[0];
        }
        for (int day = 1; day < n; day++) {
            for (int trans = 1; trans <= k; trans++) {
                long price = prices[day];
                curr[trans][0] = Math.max(prev[trans][0], Math.max(prev[trans][1] + price,  prev[trans][2] - price));
                curr[trans][1] = Math.max(prev[trans][1], prev[trans-1][0] - price);
                curr[trans][2] = Math.max(prev[trans][2], prev[trans-1][0] + price);
            }
            long[][] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[k][0]; 
    }
}