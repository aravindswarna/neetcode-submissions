class MyStack {
    Deque<Integer> dq1;
    Deque<Integer> dq2;
    int lastElem = -1;
    public MyStack() {
        dq1 = new ArrayDeque<>();
        dq2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        dq1.addLast(x);
        lastElem = x;
    }
    
    public int pop() {
        while(dq1.size() > 1){
            dq2.addLast(dq1.removeFirst());
        }
        int ans = Integer.MAX_VALUE;
        if(dq1.size()==1) {
            ans = dq1.removeFirst();
        } 
        while(!dq2.isEmpty()){
            int ele = dq2.removeFirst();
            dq1.addLast(ele);
            lastElem = ele;
        }
        return ans;
    }
    
    public int top() {
        return lastElem;
    }
    
    public boolean empty() {
        return dq1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */