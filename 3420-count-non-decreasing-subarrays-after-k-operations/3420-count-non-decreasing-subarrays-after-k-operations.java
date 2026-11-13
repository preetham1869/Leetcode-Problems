class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] val = new int[n + 1];
        int[] cnt = new int[n + 1];
        int head = n, tail = n;
        long cost = 0, ans = 0;
        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {
            int c = 1;
            while (head < tail && val[head] <= nums[left]) {
                cost += (long) (nums[left] - val[head]) * cnt[head];
                c += cnt[head];
                head++;
            }
            --head;
            val[head] = nums[left];
            cnt[head] = c;

            while (cost > k) {
                int last = tail - 1;
                cost -= val[last] - nums[right];
                right--;
                if (--cnt[last] == 0) tail--;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}