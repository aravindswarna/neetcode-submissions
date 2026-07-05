class FreqStack {

    Map<Integer, Integer> map = new HashMap<>();
    Queue<int[]> PQ = new PriorityQueue<>((a, b) -> {
        if(a[1] == b[1]){
            return Integer.compare(b[2], a[2]);
        }
        return Integer.compare(b[1],a[1]);
    });
    public FreqStack() {
        
    }
    int cc = 0;
    public void push(int val) {
        int c = map.getOrDefault(val, 0);
        c++;
        map.put(val, c);
        cc++;
        int[] arr = {val, c, cc};
        PQ.add(arr);
    }
    
    public int pop() {
        

       int[] arr = PQ.poll();
       int c = map.getOrDefault(arr[0], 0);
       c--;
        map.put(arr[0], c);
        return arr[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */