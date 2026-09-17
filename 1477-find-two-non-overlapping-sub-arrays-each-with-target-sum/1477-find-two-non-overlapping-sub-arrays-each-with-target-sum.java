class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int left = 0;
        int sum = 0;
        int minLength = -1;
        int ans = -1;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int length = right - left + 1;
                if (left > 0 && best[left - 1] != -1) {
                    int total = best[left - 1] + length;
                    if (ans == -1 || total < ans) {
                        ans = total;
                    }
                }
                if (minLength == -1 || length < minLength) {
                    minLength = length;
                }
            }
            best[right] = minLength;
        }
        return ans;
    }
}