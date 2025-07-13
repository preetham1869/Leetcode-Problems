class Solution {
    public int maximumCount(int[] nums) {
        int negCnt = 0;
        int posCnt = 0;
        for (int num : nums) {
            if (num < 0)negCnt++;
            else if (num>0)posCnt++;
        }
        return Math.max(negCnt, posCnt);
    }
}