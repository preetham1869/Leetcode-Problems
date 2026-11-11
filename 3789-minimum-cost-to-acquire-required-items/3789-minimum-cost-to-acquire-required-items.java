class Solution {
    public long minimumCost(long cost1, long cost2, long costBoth, long need1, long need2) {
        if (need1 == 0 && need2 == 0)
            return 0;
        long sub1 = cost1 * need1 + cost2 * need2;
        long sub2 = costBoth * Math.max(need1, need2);
        long ans = Math.min(sub1, sub2);
        long sub;
        if (need1 > need2) {
            sub = costBoth * need2;
            sub += (need1 - need2) * cost1;
        } else {
            sub = costBoth * need1;
            sub += (need2 - need1) * cost2;
        }
        ans = Math.min(ans, sub);
        return ans;
    }
}