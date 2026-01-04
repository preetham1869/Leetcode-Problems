class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            int sum = 1 + n;   // 1 and n are always divisors.................
            int count = 2;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    int d1 = i;
                    int d2 = n / i;
                    if (d1 == d2) {
                        sum += d1;
                        count += 1;
                    } else {
                        sum += d1 + d2;
                        count += 2;
                    }
                    if (count > 4) break;
                }
            }
            if (count == 4) {
                totalSum += sum;
            }
        }
        return totalSum;
    }
}