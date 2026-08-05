class Solution {
    private Integer[] dp;
    private int solve(int[] stoneValue, int i) {
        int n = stoneValue.length;
        if (i >= n) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int k = 0; k < 3 && i + k < n; k++) {
            sum += stoneValue[i + k];
            ans = Math.max(ans, sum - solve(stoneValue, i + k + 1));
        }
        return dp[i] = ans;
    }
    public String stoneGameIII(int[] stoneValue) {
       int n = stoneValue.length;
        dp = new Integer[n];
        int diff = solve(stoneValue, 0);
        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        } 
    }
}