class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        for (int num : nums) {
            long x = num;
            while (!st.isEmpty() && st.peek() == x) {
                x = st.pop() + x;
            }
            st.push(x);
        }
        return new ArrayList<>(st);
    }
}