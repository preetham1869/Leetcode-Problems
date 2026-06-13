class Solution {
    public int romanToInt(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int curr=val(s.charAt(i));
            if(i<s.length()-1 && curr<val(s.charAt(i+1)))res-=curr;
            else res += curr;
        }
        return res;
    }
    private int val(char ch) {
        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;
        return 1000;
    }
}