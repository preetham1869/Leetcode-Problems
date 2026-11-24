class Solution {
    public int maxLength(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long prod = 1, gcd = 0, lcm = 1;
            for (int j = i; j < nums.length; j++) {
                int x = nums[j];
                prod *= x;
                gcd = gcd(gcd, x);
                lcm = lcm / gcd(lcm, x) * x;
                if (prod == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}