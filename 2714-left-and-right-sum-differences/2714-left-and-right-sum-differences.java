class Solution {
    public int[] leftRightDifference(int[] nums) {
        int idx = 0;
        int[] arr = new int[nums.length];
            int lsum=0;
            int rsum=0;
            for(int i=1;i<nums.length;i++){
                rsum+=nums[i];
            }
            arr[idx++]=rsum;
            for(int i=1;i<nums.length;i++){
                rsum-=nums[i];
                lsum+=nums[i-1];
                arr[i]=Math.abs(lsum-rsum);
            }
        return arr;
    }
}