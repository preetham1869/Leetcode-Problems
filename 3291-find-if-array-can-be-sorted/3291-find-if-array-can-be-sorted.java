class Solution {
    public static int setBitsCount(int x) {
        return Integer.bitCount(x);
    }
    public boolean canSortArray(int[] nums) {
        int[] sortedArr = nums.clone();
        Arrays.sort(sortedArr);
        int n = nums.length;
        boolean swapped;
        do{
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (setBitsCount(nums[i]) == setBitsCount(nums[i + 1])) {
                    if (nums[i] > nums[i + 1]) {
                        int temp = nums[i];
                        nums[i] = nums[i + 1];
                        nums[i + 1] = temp;
                        swapped = true;
                    }
                }
            }
        }while(swapped);
        return Arrays.equals(nums, sortedArr);
    }
}