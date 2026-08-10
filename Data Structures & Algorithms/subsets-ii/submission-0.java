class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(nums, 0, new ArrayList<>());
        return ans;
    }

    //construct a tree whose elemnts either contain one element or doesn't contain
    //now we should sort 
    List<List<Integer>> ans = new ArrayList<>();
    public void subset(int[] nums, int i, List<Integer> list){
        if(i>= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        subset(nums, i+1, list);
        list.remove(list.size() - 1);
        int temp = i+1;
        while(temp<nums.length && nums[temp] == nums[i]) temp++;
        subset(nums, temp, list);
        
    }
}
