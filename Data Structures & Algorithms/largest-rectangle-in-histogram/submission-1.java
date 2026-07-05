class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Deque<int[]> DQ = new ArrayDeque<>();
        int maxArea = 0;
        int lastRemoved = 0;
        for(int i = 0; i<heights.length;i++){
            lastRemoved = i;
            while(!DQ.isEmpty() && heights[DQ.getLast()[1]] > heights[i]){
                int[] temp = DQ.removeLast();
                lastRemoved = temp[0];
                int leftCounter = i - temp[0];
                maxArea = Math.max(maxArea, heights[temp[1]]*(leftCounter));
            }

            
            DQ.add(new int[]{lastRemoved, i});
        }
        while(!DQ.isEmpty()){
            
            int[] temp = DQ.removeLast();
            lastRemoved = temp[0];
            int leftCounter = (heights.length) - temp[0];
            maxArea = Math.max(maxArea, heights[temp[1]]*(leftCounter)); 
            
           

        }
        return maxArea;

    }
}