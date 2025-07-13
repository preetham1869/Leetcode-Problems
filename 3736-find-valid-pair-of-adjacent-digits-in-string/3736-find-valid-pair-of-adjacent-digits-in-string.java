class Solution {
    public String findValidPair(String s) {
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int first = s.charAt(i) - '0', second = s.charAt(i + 1) - '0';
            if (first != second && cnt[first] == first && cnt[second] == second) {
                return s.substring(i, i + 2);
            }
        }
        return "";
    }
}