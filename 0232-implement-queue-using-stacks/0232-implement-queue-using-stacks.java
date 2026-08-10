class MyQueue {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> st2=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(st.isEmpty())return -1; 
        // Move all elements to st2
        while (!st.empty()) {
            st2.push(st.pop());
        }
        // Remove front element
        int ans = st2.pop();
        // Move remaining elements back
        while (!st2.empty()) {
            st.push(st2.pop());
        }
        return ans;
    }
    public int peek() {
        if (st.empty())return -1;
        // Move all elements to st2
        while (!st.empty()) {
            st2.push(st.pop());
        }
        // Front element
        int ans = st2.peek();
        // Move everything back
        while (!st2.empty()) {
            st.push(st2.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */