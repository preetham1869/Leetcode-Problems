class Solution {
    public int possibleStringCount(String word) {
        int cnt=1;
        int n = word.length();
        for (int i = 0; i < n; ){
            int j = i;
            while (j<n && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            int idx=j-i;
            if (idx>1){
                cnt+= (idx-1);
            }
            i = j;
        }
        return cnt; 
    }
}