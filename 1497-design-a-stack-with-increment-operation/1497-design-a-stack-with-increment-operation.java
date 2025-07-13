class CustomStack {
    int[] stack;
    int maxSize;
    int top;
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.maxSize=maxSize;
        this.top=-1;
    }
    public void push(int x) {
        if(top<maxSize-1)stack[++top]=x;
    }
    public int pop() {
        if(top!=-1)return stack[top--];
        return -1;
    }
    public void increment(int k,int val) {
        if(k>top+1)k=top+1;
        for(int j=0;j<k;j++)stack[j]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */