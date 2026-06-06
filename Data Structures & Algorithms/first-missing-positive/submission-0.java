class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < 0) nums[i] = 0;
        }
        for(int i = 0; i<nums.length; i++){
            int num = nums[i] < 0 ? -nums[i]: nums[i];
            if(num>=1 && num<=nums.length){
                if(nums[num-1] == 0){
                    nums[num - 1] = -(i+1);
                } else if(nums[num-1] > 0){
                    nums[num-1] = -nums[num-1];
                } 
            }
        }
        int count = 1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] >= 0){
                return count;
            }
            count++;
        }
        return count;
    }
}