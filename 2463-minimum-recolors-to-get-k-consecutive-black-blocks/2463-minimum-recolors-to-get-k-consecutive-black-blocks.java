class Solution {
    public int minimumRecolors(String blocks, int k) {
       int n = blocks.length();
        int currWCnt = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                currWCnt++;
            }
        }
        int minOps = currWCnt;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W')currWCnt--;
            if (blocks.charAt(i) == 'W')currWCnt++;
            minOps = Math.min(minOps, currWCnt);
        }
        return minOps; 
    }
}