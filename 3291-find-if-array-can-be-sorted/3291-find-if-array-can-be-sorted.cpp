class Solution {
public:
    static int setBitsCount(int x) {
        return bitset<32>(x).count();
    }
    bool canSortArray(vector<int>& nums) {
        vector<int> sortedArr = nums;
        sort(sortedArr.begin(), sortedArr.end());
        int n = nums.size();
        bool swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (setBitsCount(nums[i]) == setBitsCount(nums[i + 1])) {
                    if (nums[i] > nums[i + 1]) {
                        std::swap(nums[i], nums[i + 1]);
                        swapped = true;
                    }
                }
            }
        } while (swapped);
        return nums == sortedArr;
    }
};
