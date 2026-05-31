class Solution {
    public void sortColors(int[] nums) {
       int p1 = 0;
       int p2 = nums.length - 1;
       int i = 0;
       while(i<=p2){
        if(nums[i] == 0){
            int temp = nums[p1];
            nums[p1] = nums[i];
            nums[i] = temp;
            p1++;
            i++;
        } else if (nums[i] == 2){
            int temp = nums[p2];
            nums[p2] = nums[i];
            nums[i] = temp;
            p2--;
        } else {
            i++;
        }
        
       }
    }
}