class Solution {
    public int distinctSubseqII(String s) {
        long mod=1000000007;
        long[] last=new long[26];
        long total=0;
        for(char c:s.toCharArray()){
            int idx=c-'a';
            long newSub=(total+1)%mod;
            total=(total+newSub-last[idx]+mod)%mod;
            last[idx]=newSub;
        }
        return (int)total;
    }
}