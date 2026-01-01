class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0,cnt=0;
        long pro=1;
        if(k<=1)return 0;
        for(int i=0;i<nums.length;i++){
            pro *=nums[i];
            while(pro>=k){
                pro/=nums[l];
                l++;
            }
            cnt+=(i-l+1);
        }
        return cnt;
    }
}