class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n + 1];
        suf[n] = m;

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
        }

        int[] ans = new int[m];
        int size = 0;
        boolean changed = false;
        j = 0;

        for (int i = 0; i < n; i++) {
            if (j == m) {
                break;
            }

            char c = word1.charAt(i);

            if (c == word2.charAt(j)) {
                ans[size++] = i;
                j++;
            } else if (!changed && suf[i + 1] <= j + 1) {
                ans[size++] = i;
                j++;
                changed = true;
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}