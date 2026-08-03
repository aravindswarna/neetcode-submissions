class Task {
    char n;
    int t;
    int r;
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char task: tasks){
            map.put(task, map.getOrDefault(task,0)+1);
        }
        Queue<Task> Q = new LinkedList<>();
        Queue<Task> PQ = new PriorityQueue<>((a,b)->Integer.compare(b.r, a.r));
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            Task t = new Task();
            t.n = entry.getKey();
            t.r = entry.getValue();
            PQ.offer(t);
        }
        int tt = 0;
        while(!PQ.isEmpty() || !Q.isEmpty()){

            if(!Q.isEmpty()){
                Task t = Q.peek();
                int temp = tt - t.t;
                if(temp >= n) {
                    Q.poll();
                    PQ.offer(t);
                }
            }
            
            if(!PQ.isEmpty()){
                tt++;
                Task t = PQ.poll();
                t.r--;
                if(t.r > 0){
                    t.t = tt;
                    Q.offer(t);
                }
                
            } else if(!Q.isEmpty()) {
                Task t = Q.poll();
                int temp = tt - t.t;
                if(temp < n) tt = tt + (n - temp);
                PQ.offer(t);
            }

        }
        return tt;

    }
}
