class Solution {
    public int maxSubArray(int[] nums) {
      int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if (sum > 0)sum += nums[i];
            else sum = nums[i];
            if (sum > maxSum)maxSum = sum;
        }
        return maxSum;  
    }
}


//Kadane’s Algorithm finds the **maximum sum of a contiguous subarray** in O(n) by iterating once and updating the current subarray sum or starting a new one.
//It keeps track of the **best sum so far** and returns it at the end.
