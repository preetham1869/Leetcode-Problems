class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        if (n <= 1) return 0;
        int z = -1;
        for (int i = 0; i < n; i++) if (nums[i] == 0) { z = i; break; }
        boolean sorted = true;
        for (int j = 0; j < n; j++) if (nums[(z + j) % n] != j) { sorted = false; break; }
        if (sorted) ans = Math.min(ans, Math.min(z, n - z + 2));
        int bz = n - 1 - z;
        boolean bSorted = true;
        for (int j = 0; j < n; j++) if (nums[n - 1 - ((bz + j) % n)] != j) { bSorted = false; break; }
        if (bSorted) ans = Math.min(ans, Math.min(bz + 1, n - bz + 1));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}