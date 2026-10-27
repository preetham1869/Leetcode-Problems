class Solution {
    public boolean consecutiveSetBits(int n) {
        int pairs=n&(n>>1);
        return pairs>0 && (pairs&(pairs-1))==0;
    }
}