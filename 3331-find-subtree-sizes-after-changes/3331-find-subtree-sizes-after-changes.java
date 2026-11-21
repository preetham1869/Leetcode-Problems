
class Solution {
    List<Integer>[] children;
    int[] newParent;
    int[] last;
    int[] ans;
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        newParent = parent.clone();
        last = new int[26];
        Arrays.fill(last, -1);
        dfs(0, s);
        for (int i = 0; i < n; i++) {
            children[i].clear();
        }
        for (int i = 1; i < n; i++) {
            children[newParent[i]].add(i);
        }
        ans = new int[n];
        calculateSize(0);
        return ans;
    }
    private void dfs(int u, String s) {
        int c = s.charAt(u) - 'a';
        int previous = last[c];
        if (previous != -1) {
            newParent[u] = previous;
        }
        last[c] = u;
        for (int v : children[u]) {
            dfs(v, s);
        }
        last[c] = previous;
    }
    private int calculateSize(int u) {
        int size = 1;
        for (int v : children[u]) {
            size += calculateSize(v);
        }
        ans[u] = size;
        return size;
    }
}
