class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,sum=0,minLen=Integer.MAX_VALUE;
        for (int j=0;j<nums.length;j++){
            sum+=nums[j];
            while(sum>=target){
                minLen = Math.min(minLen,j-i+1);
                sum-=nums[i++];
            }
        }
        if(minLen==Integer.MAX_VALUE){
        return 0;
        }
        else return minLen;
    }
}