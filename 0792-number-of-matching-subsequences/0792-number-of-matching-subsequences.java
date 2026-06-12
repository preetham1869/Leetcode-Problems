class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Boolean> mp = new HashMap<>();
        int cnt = 0;
        for (String word : words) {
            if (!mp.containsKey(word))mp.put(word, isSubsequence(word, s));
            if (mp.get(word))cnt++;
        }
        return cnt;
    }
    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}