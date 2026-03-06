class Solution {
    public boolean checkOnesSegment(String s) {
        boolean z=false;
        for(char c:s.toCharArray()){
            if(c=='0')z=true;
            else if(z) return false;
        }
        return true;
    }
}