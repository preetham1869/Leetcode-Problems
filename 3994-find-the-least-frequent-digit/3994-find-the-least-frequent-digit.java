class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            int d = n % 10;
            freq[d]++;
            n /= 10;
        }
        int ans = -1, min = Integer.MAX_VALUE;
        for (int d = 0; d <= 9; d++) {
            if (freq[d] > 0 && freq[d] < min) {
                min = freq[d];
                ans = d;
            }
        }
        return ans;
    }
}