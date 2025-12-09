class Solution {
    public int specialTriplets(int[] nums) {
       int MOD = 1_000_000_007;
        int maxVal = 100_000;
        int[] left = new int[maxVal + 1];
        int[] right = new int[maxVal + 1];
        for (int num : nums) right[num]++;
        long count = 0;
        for (int num : nums) {
            right[num]--;
            int ans = num * 2;
            if (ans <= maxVal)count+=(long)left[ans]*right[ans];
            left[num]++;
        }
        return (int) (count % MOD); 
    }
}