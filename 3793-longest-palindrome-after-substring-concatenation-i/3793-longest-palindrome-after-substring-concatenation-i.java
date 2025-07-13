class Solution {
    public int longestPalindrome(String s, String t) {
        int n= s.length(),m=t.length();
        int maxi=1;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                String subS = s.substring(i, j);
                for (int x = 0; x <= m; x++) {
                    for (int y = x; y <= m; y++) {
                        String subT = t.substring(x, y);
                        String add= subS + subT;
                        if(pal(add)) 
                            maxi=Math.max(maxi,add.length());
                    }
                }
            }
        }
        return maxi;
    }
    private boolean pal(String str){
        int l= 0, r= str.length() - 1;
        while (l<r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;  
    }
}