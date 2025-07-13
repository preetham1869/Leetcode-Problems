class Solution {
    public int minBitFlips(int start, int goal) {
        String s=Integer.toString(start,2);
        String g=Integer.toString(goal,2);
        int maxLength=Math.max(s.length(),g.length());
        s=String.format("%"+maxLength+"s",s).replace(' ','0');
        g=String.format("%"+maxLength+"s",g).replace(' ','0');
        int ans=0;
        for(int i=0;i<maxLength;i++){
            if(s.charAt(i)!=g.charAt(i)) ans++;
        }
        return ans;
    }
}