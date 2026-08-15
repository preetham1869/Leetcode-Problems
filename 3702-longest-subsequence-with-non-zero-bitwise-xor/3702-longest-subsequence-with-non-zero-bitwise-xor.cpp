class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int tXor = 0;
        int zeroes = 0;
        for(int i = 0 ; i < nums.size() ; i++){
            tXor = tXor^nums[i];
            if(nums[i] == 0){
                zeroes++;
            }
        }
        if(zeroes == nums.size()) return 0;
        if(tXor != 0) return nums.size();
        return nums.size()-1;
    }
};