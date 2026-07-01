class Solution {
    static class Node {
        int temp;
        int idx;
        Node(int t, int i){
            this.temp = t;
            this.idx = i;
        }
    }
    public int[] dailyTemperatures(int[] t) {
        
        Deque<Node> DQ = new ArrayDeque<>(); 
        int[] ans = new int[t.length];
        for(int i = 0; i<t.length; i++){
            Node n = new Node(t[i], i);
            while(!DQ.isEmpty() && DQ.getLast().temp < t[i] ){
                Node h = DQ.removeLast();
                ans[h.idx] = i - h.idx;
            }
            DQ.addLast(n);
        }
        return ans;
    }
}
