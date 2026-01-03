class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        for (int x : nums) {
            if (Math.abs(x) < Math.abs(closest)) {
                closest = x;
            } 
            else if (Math.abs(x) == Math.abs(closest) && x > closest) {
                closest = x;
            }
        }
        return closest;
    }
}
