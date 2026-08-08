class Solution {
    public int subsetXORSum(int[] nums) {
        return  subSets(nums, 0, 0);
    }

    public int subSets(int[] nums, int i, int xor){
        if( i == nums.length){
            return xor;
        }
        int skip = subSets(nums, i+1, xor);
        int take = subSets(nums, i+1, xor^nums[i]);
        return skip+take;
    }
}