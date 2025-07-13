class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int size = queries.length;
        int[] res = new int[size];
        for (int i = 0; i < queries.length; i++) {
            int output = arr[queries[i][0]];
            for (int j = queries[i][0] + 1; j <= queries[i][1]; j++) {
                output ^= arr[j];
            }
            System.out.print(output + " ");
            res[i] = output;
        }
        return res;
    }
}