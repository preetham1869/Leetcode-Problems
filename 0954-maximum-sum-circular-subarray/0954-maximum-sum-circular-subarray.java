class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0,currMax=0,maxS=nums[0];
        int currMin=0,minS=nums[0];
        for(int num:nums){
            currMax=Math.max(num,currMax+num);
            maxS=Math.max(maxS,currMax);
            currMin=Math.min(num,currMin+num);
            minS=Math.min(minS,currMin);
            total+=num;
        }
        if(maxS<0)return maxS;
        return Math.max(maxS,total-minS);
    }
}