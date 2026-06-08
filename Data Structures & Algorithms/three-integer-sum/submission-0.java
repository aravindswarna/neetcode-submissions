class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Set<Set<Integer>> ansHolder = new HashSet<>();
        for(int i = 0; i<nums.length;i++){

            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j< nums.length; j++){
                int rem = (nums[j] + nums[i]);
                rem = -rem;
                if(set.contains(rem)){
                    List<Integer> ansSub = new ArrayList<>();
                    ansSub.add(nums[i]);
                    ansSub.add(nums[j]);
                    ansSub.add(rem);
                    if(!ansHolder.contains(new HashSet<>(ansSub))){
                        ans.add(ansSub);
                    }
                    ansHolder.add(new HashSet<>(ansSub));
                }
                set.add(nums[j]);
            }

        }
        return new ArrayList<>(ans);

    }
}
