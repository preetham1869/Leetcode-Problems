class Solution {
    public int[] productExceptSelf(int[] nums) {
        long prod=1;
        int zerocnt=0;
        int[] ans=new int[nums.length];
        for(int num:nums){
            if(num==0)zerocnt++;
            else prod*=num;
        }
        for(int i=0;i<nums.length;i++){
            if(zerocnt>1)ans[i]=0;
            else if(zerocnt==1){
                if(nums[i]==0){
                    ans[i]=(int)prod;
                }
                else ans[i]=0;
            }
            else ans[i]=(int)(prod/nums[i]);
        }
        return ans;
    }
}