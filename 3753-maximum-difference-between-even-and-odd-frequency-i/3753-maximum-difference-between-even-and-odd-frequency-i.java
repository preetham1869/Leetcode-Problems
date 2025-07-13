class Solution {
    public int maxDifference(String s) {
       int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;
        for (int cnt : freq) {
            if (cnt > 0) {
                if(cnt%2==0)even = Math.min(even, cnt);
                else odd = Math.max(odd, cnt);
            }
        }
        return odd - even; 
    }
}