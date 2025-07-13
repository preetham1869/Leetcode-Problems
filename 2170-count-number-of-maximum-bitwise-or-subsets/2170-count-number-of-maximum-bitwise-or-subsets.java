class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max=0;
        int n=nums.length;
        for(int num:nums){
            max |=num;
        }
        int cnt=0;
        for(int k=1;k<(1<<n);k++){
            int currOr = 0;
            for(int i=0;i<n;i++){
                if ((k & (1 << i)) != 0)currOr |= nums[i];
            }
            if (currOr==max)cnt++;
        }
        return cnt;
    }
}