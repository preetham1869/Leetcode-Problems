class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int m=nums[0];
        int ans=-1;
        for(int i=0;i<n;i++){
            if(nums[i]>m) ans=Math.max(ans,nums[i]-m);
            else m=nums[i];
        }
        return ans;
    }
}