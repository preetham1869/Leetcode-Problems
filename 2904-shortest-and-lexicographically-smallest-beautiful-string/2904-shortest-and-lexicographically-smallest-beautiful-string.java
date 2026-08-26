class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int[] pos = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                pos[cnt++] = i;
            }
        }
        if (cnt < k) {
            return "";
        }
        String ans = "";
        for (int i = 0; i + k - 1 < cnt; i++) {
            int start = pos[i];
            int end = pos[i + k - 1];
            String curr = s.substring(start, end + 1);
            if (ans.equals("") || curr.length() < ans.length() ||(curr.length() == ans.length() && curr.compareTo(ans) < 0)) {
                ans = curr;
            }
        }
        return ans;
    }
}