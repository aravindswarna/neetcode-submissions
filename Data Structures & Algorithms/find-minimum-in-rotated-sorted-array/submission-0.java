class Solution {
    public int findMin(int[] nums) {
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
        return nums[ans];
    }
}
