class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) 
            nums[i] = Math.abs(nums[i]);

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        long ans = 0;
        if (nums.length % 2 == 0)
            while (i < j) {
                ans += (long) nums[j] * nums[j];
                ans -= (long) nums[i] * nums[i];
                i++;
                j--;
            }
        else {
            while (i < nums.length / 2)
                ans -= (long) nums[i++] * nums[i-1];
            j = i;
            while (j < nums.length)
                ans += (long) nums[j] * nums[j++];
        }
        return ans;
    }
}