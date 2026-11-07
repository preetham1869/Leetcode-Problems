class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : set) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[pq.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}