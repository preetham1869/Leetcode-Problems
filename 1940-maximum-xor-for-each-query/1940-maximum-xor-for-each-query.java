class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int[] ans=new int[n];
        int opXor=0;
        for(int num:nums){
            opXor^=num;
        }
        for(int i=0;i<n;i++){
            ans[i]=(1<<maximumBit)-1 ^opXor;
            opXor^=nums[n-1-i];
        }
        return ans;
    }
}