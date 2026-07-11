class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int n = nums.length - 1;
        int ans = -1;
        while(l <= r){
            int m = l + (r - l)/2;
            if(nums[m] <= nums[n]){
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }
        if(ans > -1){
            l = nums[0] <= target ? 0 : ans;
            r = nums[n] < target ? ans - 1: nums.length - 1;
            r = r < 0 ? 0: r;
            while(l <= r){
                int m = l + (r - l)/2;
                if(nums[m] == target){
                    return m;
                } else if(nums[m] > target){
                    r = m - 1;
                } else {
                    l = m +1;
                }
            }
        }
        return -1; 
    }
}
