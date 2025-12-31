class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int l=0,r=0,maxL=0;
        while(r<s.length()){
            char c= s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            maxL=Math.max(maxL,r-l+1);
            r++;
        }
        return maxL;
    }
}