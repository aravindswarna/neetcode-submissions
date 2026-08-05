class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> EnPQ = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
                PriorityQueue<int[]> ProcPQ = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        int i = 0;
        for(int[] task: tasks){
            int[] entry = new int[]{task[0], task[1], i++};
            EnPQ.offer(entry);
        }
        int startTime = 0;
        int[] order = new int[tasks.length];
        i = 0;
        while(!EnPQ.isEmpty()){ //[2,1], [3,3] - 0
           if(startTime < EnPQ.peek()[0]){ //true
            startTime=EnPQ.peek()[0]; //1
           }
           
           while(!EnPQ.isEmpty() && startTime >= EnPQ.peek()[0]){
            ProcPQ.offer(EnPQ.poll()); //[1,4]
           }
           if(!ProcPQ.isEmpty()){
            int[] task = ProcPQ.poll(); //[1,4]
            order[i++] = task[2];  //0
            startTime+=task[1]; //5
           }

        }
        while(!ProcPQ.isEmpty()){
            int[] task = ProcPQ.poll(); //[1,4]
            order[i++] = task[2];  //0
            startTime+=task[1]; //5
           }
        return order;
    }
}