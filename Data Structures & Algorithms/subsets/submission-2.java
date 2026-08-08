class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }
    
    List<List<Integer>> subsets(int[] nums, int i){
       if(i == nums.length){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        return list;
       }
       List<List<Integer>> ans = new ArrayList<>();
       List<List<Integer>> take = subsets(nums, i+1);
       ans.addAll(take);
       for(List<Integer> list: take){
        List<Integer> newList = new ArrayList<>(list);
        newList.add(nums[i]);
        ans.add(newList);
       }
       return ans;
    }

}
