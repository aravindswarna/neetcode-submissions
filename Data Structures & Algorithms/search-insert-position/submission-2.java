class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while(l <= r){
            int m = l+ (r-l)/2;
            ans = m;
            if(target == nums[m]){
                return m;
            } else if(target < nums[m]){
                r = m - 1;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}