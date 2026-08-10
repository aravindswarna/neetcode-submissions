class Solution {
    public List<List<Integer>> permute(int[] nums) {
       permute(nums, new ArrayList<>(), new boolean[nums.length], 0); 
       return ans;

    }

    //permute, int[] nums, List so far, available array
    //base case - if list == 3 . add to ans and return
    //
    List<List<Integer>> ans = new ArrayList<>();
    public void permute(int[] nums, List<Integer> list, boolean[] visit, int j){
        if(j == nums.length){
            ans.add(new ArrayList<>(list));
        }

        for(int i = 0; i<nums.length; i++){
            if(!visit[i]){
                visit[i] = true;
                list.add(nums[i]);
                
                permute(nums, list, visit, j+1);
               
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
