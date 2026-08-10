class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int asteroid:asteroids){
            boolean collision=false;
            while (!st.isEmpty() && st.peek() > 0 && asteroid < 0) {
                if (st.peek() < -asteroid) {
                    st.pop();
                } 
                else if (st.peek() == -asteroid) {
                    st.pop();
                    collision = true;
                    break;
                } 
                else {
                    collision = true;
                    break;
                }
            }
            if (!collision) {
                st.push(asteroid);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}