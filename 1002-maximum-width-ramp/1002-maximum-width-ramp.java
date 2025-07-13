class Solution {
    public int maxWidthRamp(int[] nums){
        int n=nums.length,top=0,res=0;
        int[] st = new int[n];
        for(int i=1;i<n;i++){
            if(nums[i]<nums[st[top]]){
                st[++top]=i;
            }
        }
         for(int i=n-1;i >= res;i--){
            while (top>=0&&nums[i]>=nums[st[top]]){
                top--;
            }
            res = Math.max(res,i-st[top+1]);
        }
        return res;
    }
}