class Solution {
    public int maxAbsoluteSum(int[] nums) {
     int maxS= 0, minS = 0, currMax = 0, currMin = 0;
        for (int num : nums) {
            currMax = Math.max(num, currMax + num);
            currMin = Math.min(num, currMin + num);
            maxS = Math.max(maxS, currMax);
            minS = Math.min(minS, currMin);
        }
        return Math.max(Math.abs(maxS), Math.abs(minS));   
    }
}