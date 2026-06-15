class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int a = 1;
        for (int i = n; i >= n - 2; i--) {
            a *= nums[i];
        }
        int b = nums[0] * nums[1] * nums[n];
        return Math.max(a, b);
    }
}