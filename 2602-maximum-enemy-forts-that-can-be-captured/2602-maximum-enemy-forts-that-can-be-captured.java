class Solution {
    public int captureForts(int[] forts) {
        int c=0,max=c,prev=-1;
        for(int i=0;i<forts.length;i++){
            if(forts[i]!=0){
                prev=forts[i];
                break;
            }
        }
        for(int i=0;i<forts.length;i++){
            if(forts[i]!=0 && prev!=forts[i]){
                prev=forts[i];
                max=Math.max(c,max);
                c=0;
            }
            if(forts[i]!=0)c=0;
            if(forts[i]==0)c++;
        }
        return max;
    }
}