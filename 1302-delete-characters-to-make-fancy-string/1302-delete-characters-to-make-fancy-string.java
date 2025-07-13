class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int cnt=1;
        for(int i=0;i<s.length();i++){
            if(i>0 && s.charAt(i) == s.charAt(i-1))cnt++;
            else cnt=1;
            if (cnt<=2)res.append(s.charAt(i));
        }
        return res.toString();
    }
}