class Solution {
    public int[] resultsArray(int[] nums, int k) {
        ArrayList<Integer> res= new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n - k; i++) {
            int flag = 1;
            int j;
            for (j = i; j < i + k - 1 && j < n - 1; j++) {
                if (nums[j] >= nums[j + 1] || nums[j + 1] != nums[j] + 1) {
                    res.add(-1);
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                res.add(nums[j]);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}