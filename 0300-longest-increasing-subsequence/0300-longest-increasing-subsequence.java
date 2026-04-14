class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int arr[]=new int[n];
        int maxi=1;
        for(int i=0;i<n;i++){
            arr[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])arr[i]=Math.max(arr[i],arr[j]+1);
            }
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
}