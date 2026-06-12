class Solution {
    public int trap(int[] height) {
       int p1 = 0;
       int p2 = height.length-1;
       int maxL =  height[p1];
       int maxR = height[p2];
       int ans = 0;
       while(p1<p2){
        if(height[p1] <= height[p2]){
            if(maxL - height[p1] > 0){
                ans+=(maxL - height[p1]);
            }
            p1++;
            maxL = Math.max(maxL, height[p1]);
        } else {
            if(maxR - height[p2] > 0){
                ans+=(maxR - height[p2]);
            }
            p2--;
            maxR = Math.max(maxR, height[p2]);
        }
       }
       return ans;
    }
}
