class Solution {
    public int subsetXORSum(int[] nums) {
        List<Integer> subsetSums = subSets(nums, 0);
        int ans = 0;
        for(int ele: subsetSums){
            ans+=ele;
        }
        return ans;
    }
    //[1,2,3,4]
    public List<Integer> subSets(int[] nums, int i){
        if(i == nums.length-1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            return list;
        }
        List<Integer> subsetSums = subSets(nums, i+1); //4, 3, 3^4
        List<Integer> ans = new ArrayList<>(); 
        ans.addAll(subsetSums); //2
        ans.add(nums[i]); //[2
        for(int ele: subsetSums){
            ans.add(ele^nums[i]);  //3 ^ 4
        }
       
        return ans; //
    }

    /*

        subSets([3,1,1], i)
        //3 
        //1
        //1
        //[3,1]
        //[1,1]
        //[3,1]
        //[3,1,1]

        int[] ans = xor[1,1]

    */


}