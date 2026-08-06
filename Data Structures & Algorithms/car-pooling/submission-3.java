class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Queue<int[]> PQ = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        Queue<int[]> PQ2 = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));

        for(int[] arr: trips){
            PQ.offer(arr);
        }
       
        int currUsedCapacity = 0;
        while(!PQ.isEmpty()){
            int[] currStartPoint = PQ.poll();
            //Make sure to get down all the passengers whose end point is reached
            while(!PQ2.isEmpty() && PQ2.peek()[2]<=currStartPoint[1]){
                int[] dropOff = PQ2.poll();
                currUsedCapacity-=dropOff[0];
            }
            //board the passengers
            PQ2.offer(currStartPoint);
            currUsedCapacity+=currStartPoint[0];
            if(currUsedCapacity > capacity) return false;
        }
        return true;


    }
}