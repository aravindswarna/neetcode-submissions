class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        sum(nums, target, 0, 0, new ArrayList<Integer>());
        return ans;

    }
    List<List<Integer>> ans = new ArrayList<>();
    public void sum(int[] nums, int target, int i, int sum, List<Integer> list){
        if(i >= nums.length || sum > target){
            return;
        }
        if(sum == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        int tempSum = sum;
        for(int j = i; j<nums.length; j++){ 
            tempSum+=nums[j]; 
            list.add(nums[j]);
            sum(nums, target, j, tempSum, list); 
            list.remove(list.size()-1);
            tempSum-=nums[j];
        }

    }
}
