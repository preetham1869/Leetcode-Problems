class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0]*(n+1)
        for i in range(1,n+1):
            j = i-1
            dp[i] = max(dp[j],nums[i-1] + dp[j-1])
        return dp[n]