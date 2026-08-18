class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permuteUnique(nums, new boolean[nums.length], new ArrayList<Integer>(), 0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    public void permuteUnique(int[] nums, boolean[] visit, List<Integer> list, int count) {
        //System.out.println(list);
        if(count == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        int prev = -1;
        for(int i = 0; i<nums.length; i++){
            if(!visit[i]){
                if(prev > -1 && nums[prev] == nums[i]) continue;
                prev = i;
                visit[i] = true;
                list.add(nums[i]);
                permuteUnique(nums, visit, list, count+1);
                list.remove(list.size()-1);
                visit[i] = false;
            }
        }        
    }
}