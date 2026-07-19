class Solution {
    public int findDuplicate(int[] nums) {
        
        int fp = nums[0];
        int sp = nums[0];

        do {
            sp = nums[sp];
            fp = nums[nums[fp]];
        } while(fp != sp);

        fp = nums[0];
        while(fp != sp){
            fp = nums[fp];
            sp = nums[sp];
        }
        return sp;
    }
}
