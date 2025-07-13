class Solution {
    public String resultingString(String s) {
        StringBuilder res=  new StringBuilder();
        for(char c:s.toCharArray()){
            int n=res.length();
            if(n>0){
                char l=res.charAt(n-1);
                int d=Math.abs(c-l);
                if(d==1 || d==25){
                    res.deleteCharAt(n-1);
                    continue;
                }
            }
            res.append(c);
        }
        return res.toString();
    }
}