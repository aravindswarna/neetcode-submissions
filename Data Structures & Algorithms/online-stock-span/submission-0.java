class StockSpanner {
    class Node {
        int c;
        int p;
        Node(int p, int c){
            this.p = p;
            this.c = c;
        }
    }
    Deque<Node> DQ = null;

    public StockSpanner() {
       DQ = new ArrayDeque<>();
    }
    
    public int next(int price) {
        
        int count = 1;
        while(!DQ.isEmpty() && DQ.getLast().p <= price){
            Node n = DQ.removeLast();
            count+= n.c;
        }
        DQ.add(new Node(price, count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */