class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            boolean valid = true;
            for (int i = 0; i < n && valid; i += k) {
                valid = isRotation(nums, sorted, i, k);
            }
            if (valid) ans += k;
        }
        return ans;
    }
    private boolean isRotation(int[] nums, int[] sorted, int start, int k) {
        int[] lps = new int[k];
        for (int i = 1, len = 0; i < k;) {
            if(sorted[start+i]==sorted[start+len])lps[i++] = ++len; 
            else if(len>0)len = lps[len-1]; 
            else lps[i++]=0;
        }
        for (int i = 0, j = 0; i < 2 * k - 1;) {
            int a = nums[start + i % k];
            int b = sorted[start + j];
            if (a == b) {
                i++;
                j++;
            if (j == k) return true;
            }
            else if(j>0)j=lps[j-1];
            else i++;
        }
        return false;
    }
}