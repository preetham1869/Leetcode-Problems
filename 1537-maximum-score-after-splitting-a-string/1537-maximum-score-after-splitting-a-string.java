class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int zero=0,one=0,maxi=0;
        for(char c:s.toCharArray()){
            if(c=='1')one++;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='0')zero++;
            else one--;
            maxi=Math.max(maxi,zero+one);
        }
        return maxi;
    }
}