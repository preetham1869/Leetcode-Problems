class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }
        int[][] dist = new int[n][k + 1];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int cnt = curr[2];
            if (cost != dist[u][cnt]) continue;
            if (u == n - 1) return cost;
            for (int[] next : graph[u]) {
                int v = next[0];
                int w = next[1];
                int newcnt = (labels.charAt(u) == labels.charAt(v)) ? cnt + 1 : 1;
                if (newcnt > k) continue;
                int newCost = cost + w;
                if (newCost < dist[v][newcnt]) {
                    dist[v][newcnt] = newCost;
                    pq.offer(new int[]{newCost, v, newcnt});
                }
            }
        }
        return -1;
    }
}