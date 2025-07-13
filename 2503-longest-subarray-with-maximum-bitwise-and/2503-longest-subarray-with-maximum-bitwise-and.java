class Solution {
    public int longestSubarray(int[] nums) {
         if(nums==null) return 0;
        int maxValue = nums[0];
        for(int num_new:nums) {
            if (num_new > maxValue) {
                maxValue = num_new;
            }
        }
        int max_freq=0;
        int freq=0;
        for (int num_new : nums) {
            if (num_new == maxValue) {
                freq++;
                max_freq = Math.max(max_freq, freq);
            } else freq = 0;
        }
        return max_freq;
    }
}