class Solution {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int maxS = 0;
        int currS = 0;
        for (int i = 0; i <n; i++) {
            if(i == 0 || nums[i]>nums[i-1])currS+= nums[i];
            else {
                maxS = Math.max(maxS,currS);
                currS = nums[i];
            }
        }
        return Math.max(maxS,currS);
    }
}