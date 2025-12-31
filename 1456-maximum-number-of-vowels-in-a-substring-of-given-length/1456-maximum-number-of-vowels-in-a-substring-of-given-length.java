class Solution {
    public int maxVowels(String s, int k) {
        int c=0,maxC=0;
        for(int i=0;i<k;i++){
            if(isV(s.charAt(i)))c++;
        }
        maxC=c;
        for(int i=k;i<s.length();i++){
            if(isV(s.charAt(i)))c++;
            if(isV(s.charAt(i-k)))c--;
            maxC=Math.max(maxC,c);
        }
        return maxC;
    }
    private boolean isV(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}