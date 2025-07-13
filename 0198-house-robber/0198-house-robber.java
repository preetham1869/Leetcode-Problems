class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==1)return nums[0];
         int r2= nums[0];
        int r1= Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int currmax= Math.max(r1,r2 + nums[i]);
            r2 = r1;
            r1 = currmax;
        }
        return r1;
    }
}