class Solution {
    public int findPermutationDifference(String s, String t) {
        int ans = 0;
        for(int i=0;i<t.length();i++){
            ans+=Math.abs(i-s.indexOf(t.charAt(i)));
        }
        return ans;
    }
}