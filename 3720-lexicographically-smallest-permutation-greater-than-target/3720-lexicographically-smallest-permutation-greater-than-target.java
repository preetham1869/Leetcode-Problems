class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int bestPos = -1;
        int bestChar = -1;

        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';

            for (int c = x + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    bestPos = i;
                    bestChar = c;
                    break;
                }
            }

            if (freq[x] == 0) {
                break;
            }

            freq[x]--;
        }

        if (bestPos == -1) {
            return "";
        }

        int[] remaining = new int[26];

        for (char c : s.toCharArray()) {
            remaining[c - 'a']++;
        }

        for (int i = 0; i < bestPos; i++) {
            remaining[target.charAt(i) - 'a']--;
        }

        remaining[bestChar]--;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < bestPos; i++) {
            ans.append(target.charAt(i));
        }

        ans.append((char) ('a' + bestChar));

        for (int c = 0; c < 26; c++) {
            while (remaining[c] > 0) {
                ans.append((char) ('a' + c));
                remaining[c]--;
            }
        }

        return ans.toString();
    }
}