class Solution {
    public int countPartitions(int[] nums) {
       int n = nums.length;
        int sum=0;
        for (int num : nums)sum += num;
        int lSum = 0;
        int rSum=sum;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            lSum += nums[i];
            rSum -= nums[i];
            if ((lSum - rSum)%2==0)cnt++;
        }
        return cnt; 
    }
}