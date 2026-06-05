class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1;
        int num2 = -1;

        int count1 = 0;
        int count2 = 0;
        for(int ele: nums){
            if(num1 == ele){
                count1++;
            } else if(num2 == ele){
                count2++;
            } else if(count1 == 0){
                num1 = ele;
                count1 = 1;
            } else if(count2 == 0){
                num2 = ele;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }

        }
        count1 = count2 = 0;
        for(int ele: nums){
            if(ele == num1){
                count1++;
            } else if (ele == num2){
                count2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(count1 > (nums.length/3)) ans.add(num1);
        if(count2 > (nums.length/3)) ans.add(num2);
        return ans;
    }
}