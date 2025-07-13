class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n=gifts.length;
        for(int i=0;i<k;i++){
            int maxi=0;
            for (int j=1;j<n;j++) {
                if(gifts[j]>gifts[maxi])maxi=j;
            }
            gifts[maxi]=(int)Math.floor(Math.sqrt(gifts[maxi]));
        }
        long res=0;
        for(int gift:gifts)res+=gift;
        return res;
    }
}