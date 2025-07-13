class Solution {
    public String getHappyString(int n, int k) {
        List<String> res= new ArrayList<>();
        generateHappyStrings(n, "", res);
        if (k <= res.size()) {
            return res.get(k - 1);
        }
        return "";
    }

    private void generateHappyStrings(int n, String curr, List<String> res) {
        if (curr.length() == n) {
            res.add(curr);
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (curr.length() == 0 || curr.charAt(curr.length() - 1) != ch) {
                generateHappyStrings(n, curr+ ch, res);
            }
        }
    }
}