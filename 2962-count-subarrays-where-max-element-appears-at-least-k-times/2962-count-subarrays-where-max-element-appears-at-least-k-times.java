class Solution {
    public long countSubarrays(int[] nums, int k) {
        int l=0,maxC=0;
        long ans=0;
        int maxi=0;
        for(int n:nums){
            maxi=Math.max(maxi,n);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxi)maxC++;
            while(maxC>=k){
                ans+=nums.length-i;
                if(nums[l]==maxi)maxC--;
                l++;
            }
        }
        return ans;
    }
}