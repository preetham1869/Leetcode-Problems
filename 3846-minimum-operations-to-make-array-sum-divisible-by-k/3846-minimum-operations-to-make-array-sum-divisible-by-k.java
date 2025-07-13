class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        int r= sum % k;
        int op = 0;
        for (int i = 0; i < nums.length; i++) {
            while (r != 0 && nums[i] > 0) {
                nums[i]--;
                op++;
                r = (r - 1 + k) % k;
            }
        }
        return op;
    }
}