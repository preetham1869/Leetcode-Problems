class Solution {
    public int maxFreqSum(String s) {
      String str = "successes", v = "aeiou";
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;
        int mv = 0, mc = 0;
        for (int i = 0; i < 26; i++) {
            if (f[i] > 0) {
                if (v.indexOf(i + 'a') >= 0) mv = Math.max(mv, f[i]);
                else mc = Math.max(mc, f[i]);
            }
        }
        return mv+mc;   
    }
}