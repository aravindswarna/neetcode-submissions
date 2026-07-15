class Solution {
    int[][] mem;
    public int splitArray(int[] nums, int k) {
        mem = new int[nums.length+1][nums.length];
        for(int i = 0; i<mem.length; i++){
            Arrays.fill(mem[i], -1);
        }
        return spRec(nums, k, 0);   
    }
    
    public int spRec(int[] nums, int k, int s) {
        
        if(k == 1) {
            int sum = 0;
            for(int i = s; i<nums.length; i++){
                sum+=nums[i];
            }
            return sum;
        }
        if(mem[k][s] != -1){
            return mem[k][s];
        }
        int sum = 0;
        int maxSum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = s; i<nums.length - (k - 1); i++){
            sum+=nums[i];
            int returnedSum = spRec(nums, k-1, i+1);
            maxSum = Math.max(sum, returnedSum);
            ans = Math.min(ans, maxSum);
        }
        mem[k][s] = ans;
        return ans;
        
    }
}