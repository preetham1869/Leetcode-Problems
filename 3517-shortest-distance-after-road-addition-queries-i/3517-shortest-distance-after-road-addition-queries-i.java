class Solution {
    public static int bfs(int[][] graph,int n,int st,int end){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        queue.add(st);
        vis[st]=true;
        dis[st]=0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nb = 0; nb < n; nb++) {
                if (graph[node][nb] == 1 && !vis[nb]) {
                    vis[nb] = true;
                    dis[nb] = dis[node] + 1;
                    queue.add(nb);
                }
            }
        }
        return dis[end];
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[][] graph = new int[n][n];
        for(int i=0;i<n-1;i++){
            graph[i][i+1]=1;
        }
        int q = queries.length;
        int[] res= new int[q];
        for(int i=0;i<q;i++){
            int u = queries[i][0],v = queries[i][1];
            graph[u][v] = 1;
            res[i] = bfs(graph,n,0,n-1);
        }
        return res;
    }
}