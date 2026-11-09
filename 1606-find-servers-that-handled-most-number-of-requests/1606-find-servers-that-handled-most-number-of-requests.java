class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> set = new TreeSet<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        int[] cnt = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            set.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= arrival[i]) {
                set.add((int) pq.poll()[1]);
            }
            if (set.isEmpty()) continue;
            int id = i % k;
            Integer server = set.ceiling(id);
            if (server == null) {
                server = set.first();
            }
            set.remove(server);
            cnt[server]++;
            max = Math.max(max, cnt[server]);
            pq.offer(new long[]{(long) arrival[i] + load[i], server});
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (cnt[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }
}