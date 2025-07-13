class Solution {
    public boolean arrayIdentical(int[] arr, int[] brr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != brr[i]) {
                return false;
            }
        }
        return true;
    }
    public long minCost(int[] arr, int[] brr, long k) {
       if (arr.length == 1) return Math.abs(arr[0] - brr[0]);
       long cost = 0;
        for (int i = 0; i < arr.length; i++) {
            cost += Math.abs(arr[i] - brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        long cost1=k;
        if (arrayIdentical(arr, brr)) return cost1;
        for (int i = 0; i < arr.length; i++) {
            cost1 += Math.abs(arr[i] - brr[i]);
            arr[i] = brr[i];
        }
        return Math.min(cost, cost1);
    }
}