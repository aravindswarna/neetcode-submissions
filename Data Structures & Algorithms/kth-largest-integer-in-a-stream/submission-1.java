class KthLargest {
    Queue<Integer> Q = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int ele: nums){
            if(Q.size()< k){
                Q.offer(ele);
            } else {
                if(ele > Q.peek()){
                    Q.poll();
                    Q.offer(ele);
                }
            }
        }
    }
    
    public int add(int val) {
        if(Q.size()< k){
                Q.offer(val);
            } else {
                if(val > Q.peek()){
                    Q.poll();
                    Q.offer(val);
                }
            }
        return Q.peek();
    }
}
