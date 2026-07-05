class FreqStack {

    Map<Integer, Integer> map = new HashMap<>();
    List<Stack<Integer>> list = new ArrayList<>();
    public FreqStack() {
        list.add(new Stack<>());
    }
    public void push(int val) {
       int c = map.getOrDefault(val, 0)+1;
       map.put(val,c);
       if(list.size() == c){
            list.add(new Stack<>());
       }
       list.get(c).add(val);
    }
    
    public int pop() {
        Stack<Integer> st = list.get(list.size()-1);
        int ele = st.pop();
        int c = map.getOrDefault(ele, 0)-1;
        map.put(ele,c);
        if(st.isEmpty()){
            list.remove(list.size()-1);
        }
        return ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */