class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxS= nums[0];
        int currS= nums[0];
        for(int i=1;i<n;i++) {
            currS= Math.max(nums[i], currS+nums[i]);
            maxS=Math.max(maxS,currS);
        }
        return maxS;
    }
}