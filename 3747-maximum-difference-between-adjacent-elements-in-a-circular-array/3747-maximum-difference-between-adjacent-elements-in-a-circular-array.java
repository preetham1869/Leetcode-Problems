class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx= (i + 1) % nums.length;
            int diff1 = Math.abs(nums[i] - nums[idx]);
            diff = Math.max(diff, diff1);
        }
        return diff;
    }
}