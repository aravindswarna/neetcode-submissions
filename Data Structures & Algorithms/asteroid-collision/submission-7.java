class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> DQ = new ArrayDeque<>();
        boolean isCollided = false;
        for(int ele: asteroids){
             if(!DQ.isEmpty()){

                while(!DQ.isEmpty() && (( DQ.getLast() > 0 && ele < 0))){
                    int topA = Math.abs(DQ.getLast());
                    int eleA = Math.abs(ele);
                    if(topA == eleA || topA < eleA){
                        DQ.removeLast();
                    } 
                    if(topA == eleA || topA > eleA) {
                        isCollided = true;
                        break;
                    }
                }
             }
            
            if(!isCollided){
                DQ.addLast(ele);
            } else {
                isCollided = false;
            }

            
        }
        int[] ans = new int[DQ.size()];
        int i = 0;
            for(int ele: DQ){
                ans[i++] = ele;
            }
            return ans;
    }
}