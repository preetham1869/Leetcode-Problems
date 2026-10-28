class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        if(s.charAt(0) == (char)('0'+x))return false;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == (char)('0'+x))return true;
        }
        return false;
    }
}