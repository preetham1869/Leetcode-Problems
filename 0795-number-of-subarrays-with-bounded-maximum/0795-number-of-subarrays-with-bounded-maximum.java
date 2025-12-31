class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
       return fun(nums,right)-fun(nums,left-1); 
    }
    private int fun(int[] nums,int bound){
        int ans=0,curr=0;
        for(int num:nums){
            if(num<=bound){
                curr++;
            }
            else{
                curr=0;
            }
            ans+=curr;
        }
        return ans;
    }
}