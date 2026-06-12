class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       //[1,2,3,4,3,5,6] 3 
       Set<Integer> set = new HashSet<>();
       int i = 0;
       while(i <= k && i<nums.length){
        if(set.contains(nums[i])) return true;
        set.add(nums[i]);
        i++;
       }

       while(i < nums.length){
        //System.out.println(set);
        set.remove(nums[(i-k) - 1]);
        if(set.contains(nums[i])) return true;
        set.add(nums[i]);
        i++;
        
       }
       return false;

    }
}