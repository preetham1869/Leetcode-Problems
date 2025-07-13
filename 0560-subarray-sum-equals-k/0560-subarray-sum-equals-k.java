class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++) {
            prefixSum[i] = nums[i]+prefixSum[i-1]; 
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0,1);
        for(int i=0;i<prefixSum.length;i++) {
            res += map.getOrDefault(prefixSum[i]-k, 0);
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i],0)+1);
        } 
        return res;
    }
}