class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            if(Arrays.binarySearch(nums,i)<0)ans.add(i);
        }
        return ans;
    }
}