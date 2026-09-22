class Solution {
    int n, k;
    Node[] tree;

    class Node {
        int product;
        int[] count;

        Node() {
            product = 1;
            count = new int[k];
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        tree = new Node[4 * n];

        build(nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value % k);
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.count[x];
        }

        return ans;
    }

    void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node();
            int v = nums[l] % k;
            tree[node].product = v;
            tree[node].count[v] = 1;
            return;
        }

        int mid = l + (r - l) / 2;
        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node a, Node b) {
        Node res = new Node();
        res.product = (a.product * b.product) % k;

        for (int r = 0; r < k; r++) {
            res.count[r] += a.count[r];
            res.count[(a.product * r) % k] += b.count[r];
        }

        return res;
    }

    void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            tree[node] = new Node();
            tree[node].product = value;
            tree[node].count[value] = 1;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid)
            update(node * 2, l, mid, index, value);
        else
            update(node * 2 + 1, mid + 1, r, index, value);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr)
            return tree[node];

        int mid = l + (r - l) / 2;

        if (qr <= mid)
            return query(node * 2, l, mid, ql, qr);

        if (ql > mid)
            return query(node * 2 + 1, mid + 1, r, ql, qr);

        Node a = query(node * 2, l, mid, ql, qr);
        Node b = query(node * 2 + 1, mid + 1, r, ql, qr);

        return merge(a, b);
    }
}