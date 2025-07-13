class Solution {
    public long minimumSteps(String s) {
       long res=0;
        int zcnt=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0')zcnt++;
            else res+=zcnt;
        }
        return res;
    }
}