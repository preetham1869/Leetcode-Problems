class Solution {
    public int minOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i = nums.length - 1;
        while (i >= 0 && !set.contains(nums[i])) {
            set.add(nums[i]);
            i--;
        }
        return (i + 3) / 3;
    }
}