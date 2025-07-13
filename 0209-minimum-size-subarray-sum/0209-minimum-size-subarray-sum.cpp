class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int minLen = INT_MAX;
        int len = 0;
        for(int i = 1 ; i < nums.size() ; i++)
        {
            nums[i] = nums[i] + nums[i-1];
        }
        int i = 0;
        int j = 0;
        while(j < nums.size())
        {
            if(nums[j] >= target)
            {
                len = j-i+1;
                minLen = min(len,minLen);
                if(nums[j]-nums[i] >= target) i++;
                else 
                {
                    j++;
                    i = 0;
                }
                
            }
            else
            {
                j++;
            }
        }
        if (len != 0) return minLen;
        else return 0;
    }
};