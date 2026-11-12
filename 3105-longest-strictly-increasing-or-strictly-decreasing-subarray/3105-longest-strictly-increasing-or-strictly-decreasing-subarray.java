class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1,cnt = 1;
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            int curr = Integer.compare(nums[i], nums[i - 1]);
            if (curr == 0)cnt = 1;
            else if (prev == 0 || curr != prev)cnt = 2;
            else cnt++;
            prev = curr;
            max = Math.max(max, cnt);
        }
        return max;
    }
}