class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        List<int[]> list = new ArrayList<>();
        //create list
        for(int i = 0; i<profits.length;i++){
            list.add(new int[]{profits[i], capital[i]});
        }

        //sort
        Collections.sort(list, (a,b)->Integer.compare(a[1], b[1]));

        Queue<int[]> PQ = new PriorityQueue<>((a,b)->Integer.compare(b[0], a[0]));
        int projects = 0;
        int capital1 = w;
        int i = 0;
        while(projects <k){
            boolean progressMade = false;

            while(i<list.size() && list.get(i)[1]<=capital1){
                PQ.offer(list.get(i++));
                progressMade = true;
            }
            if(!PQ.isEmpty()){
                int[] ele = PQ.poll();
                projects++;
                capital1+=ele[0];
                if(projects == k) return capital1;
                progressMade = true;
                continue;
            }
            if(!progressMade) break;
        }
        return capital1;

        //w

        //0, 3, 1, 1

        //1,4,2,3

        //[[0,1], [1,2], [1,3], [3,4]]

        //Get all the capitals which are less than or equal to given weight

        //Add them to Heap

        //pick a max from Heap and add it to the total profit from 

        //continue this until k reaches 
    }
}