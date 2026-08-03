class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        Queue<Integer> Q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int ele: stones){
            Q.add(ele);
        }
        while(Q.size() > 1){
            Integer x = Q.poll();
            Integer y = Q.poll();
            if(x != y) Q.offer(x-y);
        }
        return Q.isEmpty() ? 0: Q.poll();
    }
}
