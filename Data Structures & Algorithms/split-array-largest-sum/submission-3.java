class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE;
        int r = 0; 
        for(int ele: nums){
            l = Math.max(l, ele);
            r += ele;
        }
        int ans = 0;
        while(l <= r){

            int m = l + (r - l)/2;
            int count = countCutsForTarget(nums, k, m);
            if(count <= k){
               ans = m;
               r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
    
    public int countCutsForTarget(int[] nums, int k, int target) {
        int sum = 0;
        int count = 0;
        for(int ele: nums) {
            sum+=ele;
            if(sum > target){
                count++;
                sum = ele;
            }
        }
        count++;
        return count;
        
    }
}