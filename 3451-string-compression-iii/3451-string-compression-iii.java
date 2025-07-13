class Solution {
    public String compressedString(String word) {
        String s="";
        int i=0;
        int n=word.length();
        while(i<n){
            char curr=word.charAt(i);
            int cnt=0;
            while(i<n&&word.charAt(i)==curr&&cnt<9){
                cnt++;
                i++;
            }
            s+=cnt+""+curr;
        }
        return s;
    }
}