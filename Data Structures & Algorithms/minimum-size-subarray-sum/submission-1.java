class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int ans = nums.length+1;
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int count = 0;
        while(p2 < nums.length && p1< nums.length){
            if(sum >= target){
                ans = Math.min(count, ans);
                sum -=nums[p1];
                p1++;
                count--;
            } else if(p2 < nums.length){
                sum += nums[p2];
                count++;
                p2++;
            }
        }
        while(p1< nums.length){
            if(sum >= target){
                ans = Math.min(count, ans);
                sum -=nums[p1];
                p1++;
                count--;
            } else break;
        }

        return ans == nums.length+1 ? 0 : ans;
    }
}