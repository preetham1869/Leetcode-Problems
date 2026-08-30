class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minIdx=0;
        int maxIdx=0;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[minIdx]){
                minIdx=i;
            }
            if(nums[i]>nums[maxIdx]){
                maxIdx=i;
            }
        }
        int left=Math.min(minIdx,maxIdx);
        int right=Math.max(minIdx,maxIdx);
        int c1=right+1;
        int c2=n-left;
        int c3=left+1+n-right;
        return Math.min(c1,Math.min(c2,c3));
    }
}