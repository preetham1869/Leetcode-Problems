class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            res[i] = cost[i];
            for (int j = 0; j < i; j++) {
                res[i] = Math.min(res[i],res[j]);
            }
        }
        return res;   
    }
}