class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long even = n / 2;
        long odd = n - even;

        long res = 1, base = 4;
        while (even > 0) {
            if ((even & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            even >>= 1;
        }

        base = 5;
        while (odd > 0) {
            if ((odd & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            odd >>= 1;
        }

        return (int) res;
    }
}
