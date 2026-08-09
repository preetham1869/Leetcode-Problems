class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : invocations) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
        }
        boolean[] suspicious = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        suspicious[k] = true;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int next : graph[curr]) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    stack.push(next);
                }
            }
        }
        for (int[] edge : invocations) {
            int from = edge[0];
            int to = edge[1];
            if (!suspicious[from] && suspicious[to]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}