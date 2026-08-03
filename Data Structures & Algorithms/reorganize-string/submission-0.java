class Task {
    char c;
    int availableAt;
    int couter;
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        Queue<Task> PQ = new PriorityQueue<>((a,b)->Integer.compare(b.couter,a.couter));
        Queue<Task> Q = new LinkedList<>();

        for(char c: arr){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            Task t = new Task();
            t.c = entry.getKey();
            t.couter = entry.getValue();
            PQ.offer(t);
        }
        StringBuilder sb = new StringBuilder();
        char prev = 'A';
        char curr = 'B';
        int t = 0;
        while(!PQ.isEmpty() || !Q.isEmpty()){
            if(!Q.isEmpty() && Q.peek().c != prev){
                PQ.offer(Q.poll());
            } 

            if(PQ.isEmpty() && !Q.isEmpty()){
                PQ.offer(Q.poll());
            }
        
            if(!PQ.isEmpty()){
                Task t1 = PQ.poll();
                sb.append(t1.c);
                curr = t1.c;
                System.out.println(prev+"--"+curr);
                if(prev == curr) return "";
                t1.couter--;
                if(t1.couter > 0){
                    Q.offer(t1);
                }
                prev = curr;
            }
            
        }
        return sb.toString();
    }
}