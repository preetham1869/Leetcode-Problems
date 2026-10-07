class Solution {
    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, 0, new StringBuilder());

        return new ArrayList<>(result);
    }

    void dfs(String s, int i, int left, int right,
             int balance, StringBuilder curr) {

        if (i == s.length()) {
            if (left == 0 && right == 0 && balance == 0) {
                result.add(curr.toString());
            }
            return;
        }

        char c = s.charAt(i);

        if (c == '(') {
            if (left > 0) {
                dfs(s, i + 1, left - 1, right, balance, curr);
            }

            curr.append(c);
            dfs(s, i + 1, left, right, balance + 1, curr);
            curr.deleteCharAt(curr.length() - 1);

        } else if (c == ')') {
            if (right > 0) {
                dfs(s, i + 1, left, right - 1, balance, curr);
            }

            if (balance > 0) {
                curr.append(c);
                dfs(s, i + 1, left, right, balance - 1, curr);
                curr.deleteCharAt(curr.length() - 1);
            }

        } else {
            curr.append(c);
            dfs(s, i + 1, left, right, balance, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}