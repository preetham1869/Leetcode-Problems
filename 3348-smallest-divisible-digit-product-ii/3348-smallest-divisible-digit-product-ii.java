class Solution {
    private static final int[] cnt2 = {0, 0, 1, 0, 2, 0, 1, 0, 3, 0};
    private static final int[] cnt3 = {0, 0, 0, 1, 0, 0, 1, 0, 0, 2};
    private static final int[] cnt5 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
    private static final int[] cnt7 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};

    private int[][] dp = new int[60][60];

    public String smallestNumber(String num, long t) {
        // Step 1: Factorize t into prime factors 2, 3, 5, 7
        long tempT = t;
        int reqA = 0, reqB = 0, reqC = 0, reqD = 0;
        while (tempT % 2 == 0) { reqA++; tempT /= 2; }
        while (tempT % 3 == 0) { reqB++; tempT /= 3; }
        while (tempT % 5 == 0) { reqC++; tempT /= 5; }
        while (tempT % 7 == 0) { reqD++; tempT /= 7; }
        
        // If t has prime factors other than 2, 3, 5, 7, impossible!
        if (tempT > 1) return "-1";

        // Step 2: Compute DP table for min digits needed for (2^a * 3^b)
        initDp();

        int n = num.length();
        int firstZeroIdx = n;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                firstZeroIdx = i;
                break;
            }
        }

        // Step 3: Compute remaining required factors after each prefix of num
        int[] prefA = new int[firstZeroIdx + 1];
        int[] prefB = new int[firstZeroIdx + 1];
        int[] prefC = new int[firstZeroIdx + 1];
        int[] prefD = new int[firstZeroIdx + 1];

        prefA[0] = reqA; prefB[0] = reqB; prefC[0] = reqC; prefD[0] = reqD;

        for (int i = 1; i <= firstZeroIdx; i++) {
            int d = num.charAt(i - 1) - '0';
            prefA[i] = Math.max(0, prefA[i - 1] - cnt2[d]);
            prefB[i] = Math.max(0, prefB[i - 1] - cnt3[d]);
            prefC[i] = Math.max(0, prefC[i - 1] - cnt5[d]);
            prefD[i] = Math.max(0, prefD[i - 1] - cnt7[d]);
        }

        // Check if num itself is zero-free and valid
        if (firstZeroIdx == n && prefA[n] == 0 && prefB[n] == 0 && prefC[n] == 0 && prefD[n] == 0) {
            return num;
        }

        // Step 4: Try to match a prefix of length i (from n-1 down to 0)
        for (int i = Math.min(n - 1, firstZeroIdx); i >= 0; i--) {
            int startD = (i == firstZeroIdx) ? 1 : (num.charAt(i) - '0') + 1;
            int remL = n - 1 - i;
            
            int curA = prefA[i];
            int curB = prefB[i];
            int curC = prefC[i];
            int curD = prefD[i];

            for (int d = startD; d <= 9; d++) {
                int nxtA = Math.max(0, curA - cnt2[d]);
                int nxtB = Math.max(0, curB - cnt3[d]);
                int nxtC = Math.max(0, curC - cnt5[d]);
                int nxtD = Math.max(0, curD - cnt7[d]);

                if (remL >= getMinLen(nxtA, nxtB, nxtC, nxtD)) {
                    StringBuilder res = new StringBuilder();
                    res.append(num, 0, i);
                    res.append((char) ('0' + d));
                    res.append(buildSuffix(remL, nxtA, nxtB, nxtC, nxtD));
                    return res.toString();
                }
            }
        }

        // Step 5: No length n number exists, find smallest length > n
        int targetLen = Math.max(n + 1, getMinLen(reqA, reqB, reqC, reqD));
        return buildSuffix(targetLen, reqA, reqB, reqC, reqD);
    }

    private void initDp() {
        for (int i = 0; i < 60; i++) Arrays.fill(dp[i], 1000);
        dp[0][0] = 0;

        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                if (i == 0 && j == 0) continue;
                int minV = 1000;
                minV = Math.min(minV, 1 + dp[Math.max(0, i - 1)][j]); // digit 2
                minV = Math.min(minV, 1 + dp[i][Math.max(0, j - 1)]); // digit 3
                minV = Math.min(minV, 1 + dp[Math.max(0, i - 2)][j]); // digit 4
                minV = Math.min(minV, 1 + dp[Math.max(0, i - 1)][Math.max(0, j - 1)]); // digit 6
                minV = Math.min(minV, 1 + dp[Math.max(0, i - 3)][j]); // digit 8
                minV = Math.min(minV, 1 + dp[i][Math.max(0, j - 2)]); // digit 9
                dp[i][j] = minV;
            }
        }
    }

    private int getMinLen(int a, int b, int c, int d) {
        return c + d + dp[Math.min(a, 59)][Math.min(b, 59)];
    }

    private String buildSuffix(int len, int a, int b, int c, int d) {
        StringBuilder sb = new StringBuilder();
        int minL = getMinLen(a, b, c, d);
        int ones = len - minL;
        
        for (int k = 0; k < ones; k++) {
            sb.append('1');
        }

        int remL = minL;
        int curA = a, curB = b, curC = c, curD = d;

        for (int pos = 0; pos < minL; pos++) {
            remL--;
            for (int x = 1; x <= 9; x++) {
                int nxtA = Math.max(0, curA - cnt2[x]);
                int nxtB = Math.max(0, curB - cnt3[x]);
                int nxtC = Math.max(0, curC - cnt5[x]);
                int nxtD = Math.max(0, curD - cnt7[x]);

                if (remL >= getMinLen(nxtA, nxtB, nxtC, nxtD)) {
                    sb.append((char) ('0' + x));
                    curA = nxtA; curB = nxtB; curC = nxtC; curD = nxtD;
                    break;
                }
            }
        }
        return sb.toString();
    }
}