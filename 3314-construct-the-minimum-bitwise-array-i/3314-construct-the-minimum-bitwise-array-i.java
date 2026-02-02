class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if (num == 2) {
                ans[i] = -1;
                continue;
            }
            int x = 1;
            while ((num & x) != 0) {
                x <<= 1;
            }
            ans[i] = num ^ (x >> 1);
        }
        return ans;
    }
}
