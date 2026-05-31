class Solution {
    public int[] sortArray(int[] nums) {
       return insertionSort(nums);
    }
    int[] bubbleSort(int[] nums){
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n-1-i; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
    int[] insertionSort(int[] nums){
        int n = nums.length;
        for(int i = 1; i<n; i++){
           int j = i-1;
           int pivot = nums[i];
           while(j>=0 && nums[j] > pivot){
            nums[j+1] = nums[j];
            j = j-1;
           }
           nums[j+1] = pivot;
        }
        return nums;
    }
}