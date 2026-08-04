class Solution {
    public int[] sortArray(int[] nums) {
        int offset=50000;
        int[]cnt=new int[100001];
        for(int num:nums)cnt[num+offset]++;
        int idx=0;
        for(int i=0;i<cnt.length;i++){
            while(cnt[i]>0){
                nums[idx++]=i-offset;
                cnt[i]--;
            }
        }
        return nums;
    }
}