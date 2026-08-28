class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int m = n / 2;
        int[] halfCnt = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCnt[i] = cnt[i] / 2;
        }

        char[] half = new char[m];
        int p = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < halfCnt[i]; j++) {
                half[p++] = (char) ('a' + i);
            }
        }

        String smallest = makePalindrome(half, mid, n);

        if (smallest.compareTo(target) > 0) {
            return smallest;
        }

        int[] remaining = halfCnt.clone();

        boolean possible = true;

        for (int i = 0; i < m; i++) {
            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            remaining[c]--;
        }

        if (possible) {
            char[] candidate = new char[m];

            for (int i = 0; i < m; i++) {
                candidate[i] = target.charAt(i);
            }

            String result = makePalindrome(candidate, mid, n);

            if (result.compareTo(target) > 0) {
                return result;
            }
        }

        for (int i = m - 1; i >= 0; i--) {

            remaining = halfCnt.clone();
            possible = true;

            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (remaining[c] == 0) {
                    continue;
                }

                char[] candidate = new char[m];

                for (int j = 0; j < i; j++) {
                    candidate[j] = target.charAt(j);
                }

                candidate[i] = (char) ('a' + c);
                remaining[c]--;

                int index = i + 1;

                for (int x = 0; x < 26; x++) {
                    while (remaining[x] > 0) {
                        candidate[index++] = (char) ('a' + x);
                        remaining[x]--;
                    }
                }

                String result = makePalindrome(candidate, mid, n);

                if (result.compareTo(target) > 0) {
                    return result;
                }
            }
        }

        return "";
    }

    private String makePalindrome(char[] half, char mid, int n) {

        StringBuilder ans = new StringBuilder();

        for (char c : half) {
            ans.append(c);
        }

        if (n % 2 == 1) {
            ans.append(mid);
        }

        for (int i = half.length - 1; i >= 0; i--) {
            ans.append(half[i]);
        }

        return ans.toString();
    }
}