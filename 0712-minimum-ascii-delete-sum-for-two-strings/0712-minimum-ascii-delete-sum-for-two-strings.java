class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] arr = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--)
            arr[i][n] = arr[i + 1][n] + s1.charAt(i);

        for (int j = n - 1; j >= 0; j--)
            arr[m][j] = arr[m][j + 1] + s2.charAt(j);

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1];
                else
                    arr[i][j] = Math.min(
                        s1.charAt(i) + arr[i + 1][j],
                        s2.charAt(j) + arr[i][j + 1]
                    );
            }
        }
        return arr[0][0];
    }
}
