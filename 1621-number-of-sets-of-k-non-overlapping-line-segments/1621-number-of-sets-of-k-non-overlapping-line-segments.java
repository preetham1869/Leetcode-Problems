class Solution {
    public int numberOfSets(int n, int k) {
        long ans = 1;
        int MOD = 1000000007;
        int n1 = n + k - 1;
        int r = 2 * k;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n1 - r + i) % MOD;
            ans = ans * modInverse(i, MOD) % MOD;
        }
        return (int) ans;
    }
    private long modInverse(long x, int MOD) {
        return power(x, MOD - 2, MOD);
    }
    private long power(long a, long b, int MOD) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}