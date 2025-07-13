class Solution {
    public boolean strictlyIncreasing(int start, List<Integer> nums, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        
        for (int j = 0; j <= n - 2 * k; j++) {
            if (strictlyIncreasing(j, nums, k) && strictlyIncreasing(j + k, nums, k)) {
                return true;
            }
        }

        return false;
    }
}
