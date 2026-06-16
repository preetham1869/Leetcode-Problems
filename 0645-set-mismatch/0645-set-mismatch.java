class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        for (int num : nums)freq[num]++;
        int dup=0;
        int miss=0;
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) dup = i;
            if (freq[i] == 0) miss = i;
        }
        return new int[]{dup, miss};
    }
}