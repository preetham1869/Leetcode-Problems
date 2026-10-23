class Solution {
    public int sortPermutation(int[] nums) {
        int k = 0;
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (!found) {
                    k = nums[i];
                    found = true;
                } 
                else {
                    k &= nums[i];
                }
            }
        }
        return found ? k : 0;
    }
}