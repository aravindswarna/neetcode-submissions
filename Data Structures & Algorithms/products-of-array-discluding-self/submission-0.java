class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length+1];
        int[] right = new int[nums.length+1];
        int[] ans = new int[nums.length];
        left[0] = 1;
        right[nums.length] = 1;
        for(int i = 0; i<nums.length;i++){
            left[i+1] = nums[i]*left[i];
        }
        //[1,2,4,6]
        //[1,1,2,8,48]
        //[48,48,24,6,1]
        //[1,1,2,8,48]
        //[48,48,24,6,1]
        for(int j = nums.length-1; j>=0;j--){
            right[j] = nums[j]*right[j+1];
        }
        System.out.println(Arrays.toString(left)+":"+Arrays.toString(right));
        for(int i = 0; i<nums.length; i++){
            ans[i] = left[i]*right[i+1];
        }
        return ans;
    }
}  
