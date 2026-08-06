class MedianFinder {

    Queue<Integer> minQ = new PriorityQueue<>();
    Queue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxQ.isEmpty() || num<maxQ.peek()){
            maxQ.offer(num);
        } else {
            minQ.offer(num);
        }

        if(maxQ.size() > (minQ.size()+1)){
            minQ.offer(maxQ.poll());
        } else if(minQ.size() > (maxQ.size()+1)){
            maxQ.offer(minQ.poll());
        }
    }
    
    public double findMedian() {
        if(maxQ.size() == minQ.size()){
            return (maxQ.peek()+minQ.peek())/2.0;
        } else {
            return maxQ.size() > minQ.size() ? maxQ.peek(): minQ.peek();
        }
    }
}
