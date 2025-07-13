class Solution {
    public int[] maxSubsequence(int[] nums, int k){
        List<int[]> lst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            lst.add(new int[]{nums[i], i});
        }
        lst.sort((a, b) -> b[0] - a[0]);
        List<int[]> top= lst.subList(0, k);
        top.sort(Comparator.comparingInt(a -> a[1]));
        int[] res= new int[k];
        for (int i = 0; i < k; i++){
            res[i] = top.get(i)[0];
        }
        return res;
    }
}