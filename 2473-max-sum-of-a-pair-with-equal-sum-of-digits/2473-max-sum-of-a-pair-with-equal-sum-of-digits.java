class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxS = -1;
        for (int num : nums) {
            int sum = 0,temp = num;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (mp.containsKey(sum)) {
                maxS= Math.max(maxS, mp.get(sum) + num);
                mp.put(sum, Math.max(mp.get(sum), num));
            } else {
                mp.put(sum,num);
            }
        }
        return maxS;
    }
}