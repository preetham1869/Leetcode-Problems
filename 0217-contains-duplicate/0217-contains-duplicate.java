class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> vis = new HashSet<>();
        for (int x : nums) {
            if (vis.contains(x)) return true;
            vis.add(x);
        }
        return false;
    }
}