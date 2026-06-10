class Solution {
    public int maxArea(int[] heights) {
        //[1,7,2,5,4,7,3,6]
        //[1,3,1,1,1,1]
        //[1,7,2 ]

        int p1 = 0;
        int p2 = heights.length - 1;
        int area = 0;
        while(p1 < p2){
         area = Math.max(area, Math.min(heights[p1], heights[p2])*(p2-p1));
         if(heights[p1]< heights[p2])p1++;
         else p2--;
        }
        return area;
    }
}
