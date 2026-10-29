class Solution {
    int[] tin, tout, depth, bit;
    int[][] up;
    int timer, LOG;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[LOG][n];
        bit = new int[2 * n + 2];
        timer = 0;
        dfs(0, 0, adj);
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            updateBIT(tin[i], mask);
            updateBIT(tout[i], mask);
        }
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            int u = Integer.parseInt(parts[1]);
            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);
                if (chars[u] != c) {
                    int mask = (1 << (chars[u] - 'a')) ^ (1 << (c - 'a'));
                    updateBIT(tin[u], mask);
                    updateBIT(tout[u], mask);
                    chars[u] = c;
                }
            } 
            else {
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v);
                int mask = queryBIT(tin[u]) ^ queryBIT(tin[v])
                         ^ (1 << (chars[lca] - 'a'));
                ans.add((mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }
    void dfs(int u, int p, List<Integer>[] adj) {
        tin[u] = ++timer;
        up[0][u] = p;
        for (int j = 1; j < LOG; j++)
            up[j][u] = up[j - 1][up[j - 1][u]];
        for (int v : adj[u]) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            dfs(v, u, adj);
        }
        tout[u] = ++timer;
    }
    void updateBIT(int i, int mask) {
        for (; i < bit.length; i += i & -i)
            bit[i] ^= mask;
    }
    int queryBIT(int i) {
        int mask = 0;
        for (; i > 0; i -= i & -i)
            mask ^= bit[i];
        return mask;
    }
    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }
        int diff = depth[u] - depth[v];
        for (int j = 0; j < LOG; j++)
            if ((diff & (1 << j)) != 0)
                u = up[j][u];
        if (u == v) return u;
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }
        return up[0][u];
    }
}