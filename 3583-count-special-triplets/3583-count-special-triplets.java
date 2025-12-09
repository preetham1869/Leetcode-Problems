class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0) + 1);
        }
        long result = 0;
        for (int x : nums) {
            right.put(x, right.get(x) - 1);
            int need = x * 2;
            long l = left.getOrDefault(need, 0);
            long r = right.getOrDefault(need, 0);
            result += l * r;

            left.put(x, left.getOrDefault(x, 0) + 1);
        }
        return (int) (result % MOD);
    }
}
