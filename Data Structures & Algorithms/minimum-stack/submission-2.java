class MinStack {

    static class Entry{
        int ele;
        int min;
        Entry(int ele, int min){
            this.ele = ele;
            this.min = min;
        }
    }
    int min = Integer.MAX_VALUE;
    List<Entry> data;
    public MinStack() {
        data = new ArrayList<>(); 
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        Entry e = new Entry(val, min);
        data.add(e);
    }
    

    /*
        -2, 0, 2, -4, 3 
    */
    public void pop() {
        if(!data.isEmpty()){
            data.remove(data.size()-1);
            if(!data.isEmpty()){
                min = getMin();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        if(!data.isEmpty())
        return data.get(data.size()-1).ele;
        return -1;
    }
    
    public int getMin() {
        if(!data.isEmpty())
        return data.get(data.size()-1).min;
        return -1;
    }
}
