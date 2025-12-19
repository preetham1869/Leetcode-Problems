class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int tv = vc(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (vc(words[i]) == tv) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }

        return String.join(" ", words);
    }

    private int vc(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
