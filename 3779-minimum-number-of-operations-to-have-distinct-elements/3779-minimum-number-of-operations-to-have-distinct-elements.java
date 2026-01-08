class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int dup = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) == 2) dup++;
        }
        if (dup == 0) return 0;
        int ops = 0, i = 0;
        while (i < nums.length) {
            for (int k = 0; k < 3 && i < nums.length; k++) {
                int v = nums[i];
                freq.put(v, freq.get(v) - 1);
                if (freq.get(v) == 1) dup--;
                i++;
            }
            ops++;
            if (dup == 0) return ops;
        }
        return ops;
    }
}