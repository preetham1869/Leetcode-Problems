class Solution {
    public String smallestPalindrome(String s) {
       int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder half = new StringBuilder();
        String mid= "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (freq[i] % 2 == 1) {
                mid = String.valueOf(ch);
                freq[i]--;
            }
            for (int j = 0; j < freq[i] / 2; j++)half.append(ch);
        }
        String half1 = new StringBuilder(half).reverse().toString();
        return half.toString()+mid+half1;
    } 
}